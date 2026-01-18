package com.bookln.bookln.model;

public class Court {
    private String name;
    private String location;
    private String imageUrl;
    private String number; // WhatsApp Number

    public Court(String name, String location, String imageUrl, String number) {
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNumber() {
        return number;
    }
}