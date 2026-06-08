package com.bookln.bookln.model;

public class Booking {
    private String courtName;
    private String date;
    private String time;

    private Booking(BookingBuilder builder) {
        this.courtName = builder.courtName;
        this.date = builder.date;
        this.time = builder.time;
    }

    public String getCourtName() {
        return courtName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    // The Builder Class
    public static class BookingBuilder {
        private String courtName;
        private String date;
        private String time;

        public BookingBuilder setCourtName(String courtName) {
            this.courtName = courtName;
            return this;
        }

        public BookingBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public BookingBuilder setTime(String time) {
            this.time = time;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}