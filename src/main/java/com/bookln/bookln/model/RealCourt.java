package com.bookln.bookln.model;

public class RealCourt extends Court {
    public RealCourt(String name, String location, String imageUrl, long number) {
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
        this.number = number;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}
