package com.bookln.bookln.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    // This mimics your python 'usr_data' dictionary
    private Map<String, String> usrData = new HashMap<>();

    public AuthService() {
        // Initialize empty keys just like in your app.py
        usrData.put("username", "");
        usrData.put("email", "");
        usrData.put("pass", "");
        usrData.put("firstname", "");
        usrData.put("lastname", "");
    }

    public void registerUser(String firstname, String lastname, String username, String email, String password) {
        // Overwrite the dictionary with the new user (Single user storage)
        usrData.put("firstname", firstname);
        usrData.put("lastname", lastname);
        usrData.put("username", username);
        usrData.put("email", email);
        usrData.put("pass", password);

        System.out.println("Updated usr_data: " + usrData);
    }

    public boolean validateLogin(String username, String password) {
        // Check if the input matches the stored data
        String storedUser = usrData.get("username");
        String storedPass = usrData.get("pass");

        return username != null && username.equals(storedUser) &&
                password != null && password.equals(storedPass);
    }

    public Map<String, String> getUserData() {
        return usrData;
    }
}