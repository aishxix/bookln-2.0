package com.bookln.bookln.model;

public class NullCourt extends Court {
    public NullCourt() {
        this.name = "No Court Found";
        this.location = "N/A";
        this.imageUrl = "/images/default.jpg";
        this.number = 0;
    }

    @Override
    public boolean isNil() {
        return true; // Prevents NullPointerExceptions in Thymeleaf
    }
}
