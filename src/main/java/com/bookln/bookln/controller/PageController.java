package com.bookln.bookln.controller;

import com.bookln.bookln.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Controller
public class PageController {

    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/about")
    public String about() {
        return "forward:/about.html";
    }

    @GetMapping("/contact")
    public String contact() {
        return "forward:/contact.html";
    }

    // --- Login Logic ---

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            return "redirect:/indoor";
        }
        return "forward:/login.html";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        if (authService.validateLogin(username, password)) {
            session.setAttribute("currentUser", username);
            return "redirect:/indoor";
        } else {
            // Failed login - redirect back to login page
            // (Since no thymeleaf, we can't easily show error messages dynamically without
            // URL params)
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // --- Signup Logic ---

    @GetMapping("/signup")
    public String signupPage() {
        return "forward:/signup.html";
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

    // --- Restricted Area Logic ---

    @GetMapping("/indoor")
    public String indoor(HttpSession session) {
        // SECURITY CHECK: If no user in session, redirect to login
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }
        // If logged in, serve the static file
        return "forward:/indoor.html";
    }

    // --- Booking Logic (WhatsApp Redirect) ---

    @GetMapping("/book")
    public RedirectView bookNow(@RequestParam("date") String dateStr,
            @RequestParam("court") String courtName,
            @RequestParam("time") String timeSlot,
            @RequestParam("number") String phoneNumber,
            HttpSession session) {

        if (session.getAttribute("currentUser") == null) {
            return new RedirectView("/login");
        }

        try {
            // Basic date check logic mimicking your Python code
            LocalDate selectedDate = LocalDate.parse(dateStr);
            if (selectedDate.isBefore(LocalDate.now())) {
                System.out.println("Error: Past date selected");
                return new RedirectView("/indoor");
            }

            // Fetch user details from the 'Dictionary' in AuthService
            String firstName = authService.getUserData().get("firstname");
            String lastName = authService.getUserData().get("lastname");

            String message = String.format(
                    "Hello! I'm %s %s I would like to book the %s for %s & Time Slot %s slot. Can you confirm the availability and price?",
                    firstName, lastName, courtName, dateStr, timeSlot);

            String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
            String whatsappUrl = String.format("https://api.whatsapp.com/send?phone=%s&text=%s", phoneNumber,
                    encodedMessage);

            return new RedirectView(whatsappUrl);

        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/indoor");
        }
    }
}