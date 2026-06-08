package com.bookln.bookln.controller;

import com.bookln.bookln.model.SystemConfig;
import com.bookln.bookln.model.Court;
import com.bookln.bookln.service.AuthService;
import com.bookln.bookln.service.CourtDataService;
import jakarta.servlet.http.HttpSession;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.bookln.bookln.model.Booking;
import com.bookln.bookln.service.BookingSubject;

@Controller
public class PageController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CourtDataService courtService;

    // --- Simple Pages ---

    @GetMapping("/")
    public String home() {
        return "index"; // Looks for templates/index.html
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // Looks for templates/about.html
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // Looks for templates/contact.html
    }

    // --- Login & Signup ---

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            return "redirect:/indoor";
        }
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
            @RequestParam String password,
            HttpSession session) {
        if (authService.validateLogin(username, password)) {
            session.setAttribute("currentUser", username);
            return "redirect:/indoor";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password) {
        authService.registerUser(firstname, lastname, username, email, password);
        return "redirect:/login";
    }

    // --- The Main DSA Page (Indoor) ---

    @GetMapping("/indoor")
    public String indoor(HttpSession session,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "sort", required = false) String sort, // NEW PARAM
            Model model) {

        // 1. Security Check
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }

        // 2. Search (Linear Search)
        // This returns an array of matches (or all courts if search is empty)
        Court[] results = courtService.searchCourts(search);

        // 3. Sort (Bubble Sort)
        // If the user picked a sort order, we run the algorithm on the results array
        if (sort != null && !sort.isEmpty()) {
            courtService.sortCourts(results, sort);
        }

        // 4. Pass final data to HTML
        model.addAttribute("courts", results);

        return "indoor";
    }

    @GetMapping("/book")
    public RedirectView bookNow(@RequestParam("date") String dateStr,
            @RequestParam("court") String courtName,
            @RequestParam("time") String timeSlot,
            @RequestParam("number") String phoneNumber,
            HttpSession session) {

        // 1. Singleton Pattern Implementation
        System.out.println("Processing booking via: " + SystemConfig.getInstance().getAppName());

        // 2. Builder Pattern Implementation
        Booking newBooking = new Booking.BookingBuilder()
                .setCourtName(courtName)
                .setDate(dateStr)
                .setTime(timeSlot)
                .build();

        // 3. Observer Pattern Implementation
        BookingSubject subject = new BookingSubject();
        subject.notifyAllObservers(
                "New booking received for " + newBooking.getCourtName() + " at " + newBooking.getTime());

        // 1. Check if user is logged in
        if (session.getAttribute("currentUser") == null) {
            return new RedirectView("/login");
        }

        try {
            // --- THE FIX IS HERE ---
            // Remove all spaces, dashes, and dots from the phone number
            String cleanNumber = phoneNumber.replaceAll("[^0-9]", "");

            // Validate Date
            LocalDate selectedDate = LocalDate.parse(dateStr);
            if (selectedDate.isBefore(LocalDate.now())) {
                System.out.println("Error: User tried to book a past date.");
                return new RedirectView("/indoor");
            }

            // Get User Info
            String firstName = authService.getUserData().get("firstname");
            String lastName = authService.getUserData().get("lastname");

            // Format Message
            String message = String.format(
                    "Hello! I'm %s %s. I would like to book the %s for %s, Time Slot: %s. Can you confirm availability?",
                    firstName, lastName, courtName, dateStr, timeSlot);

            String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);

            // Create WhatsApp URL with the CLEAN number
            String whatsappUrl = String.format("https://api.whatsapp.com/send?phone=%s&text=%s", cleanNumber,
                    encodedMessage);

            return new RedirectView(whatsappUrl);

        } catch (Exception e) {
            // Print the actual error to your console
            System.out.println("Booking Failed! Error: " + e.getMessage());
            e.printStackTrace();
            return new RedirectView("/indoor");
        }

    }
}