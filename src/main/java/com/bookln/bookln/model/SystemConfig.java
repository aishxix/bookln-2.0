package com.bookln.bookln.model;

public class SystemConfig {
    private static SystemConfig instance;
    private String appName = "Bookln Indoor Management System";

    private SystemConfig() {
    } // Private constructor

    public static SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }
}