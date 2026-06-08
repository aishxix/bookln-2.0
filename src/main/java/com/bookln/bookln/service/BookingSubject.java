package com.bookln.bookln.service;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String message);
}

// Concrete Observers
class AdminObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ADMIN DASHBOARD ALERT: " + message);
    }
}

class MaintenanceObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("MAINTENANCE STAFF ALERT: " + message);
    }
}

// Subject Class
public class BookingSubject {
    private List<Observer> observers = new ArrayList<>();

    public BookingSubject() {
        // Automatically attach observers when created
        attach(new AdminObserver());
        attach(new MaintenanceObserver());
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
