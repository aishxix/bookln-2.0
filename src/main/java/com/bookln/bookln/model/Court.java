package com.bookln.bookln.model;

// public class Court {
//     private String name;
//     private String location;
//     private String imageUrl;
//     private String number;

//     public Court(String name, String location, String imageUrl, String number) {
//         this.name = name;
//         this.location = location;
//         this.imageUrl = imageUrl;
//         this.number = number;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getLocation() {
//         return location;
//     }

//     public String getImageUrl() {
//         return imageUrl;
//     }

//     public String getNumber() {
//         return number;
//     }
// }

public abstract class Court {
    protected String name;
    protected String location;
    protected String imageUrl;
    protected long number;

    // The Null Object pattern requirement
    public abstract boolean isNil();

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getNumber() {
        return number;
    }
}