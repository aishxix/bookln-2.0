package com.bookln.bookln.service;

import com.bookln.bookln.model.*;

// Factory Pattern
public class CourtFactory {
    public static Court getCourt(String name, String location, String img, long num) {
        if (name == null || name.isEmpty()) {
            return new NullCourt();
        }
        return new RealCourt(name, location, img, num);
    }
}
