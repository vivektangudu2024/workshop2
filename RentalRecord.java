package com.workshop2;

import java.util.Date;

class RentalRecord {
    private Date rentalDate;
    private Date returnDate;
    private Customer customer;
    private Car car;
    private int duration; // Duration in days

    public RentalRecord(Date rentalDate, Customer customer, Car car) {
        this.rentalDate = rentalDate;
        this.customer = customer;
        this.car = car;
        this.duration = 0; // Initialize duration to 0, as the car is not yet returned
    }

    // Getters
    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDuration() {
        return duration;
    }

    // Setters
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        // Calculate duration based on return date and rental date
        if (rentalDate != null && returnDate != null) {
            long diff = returnDate.getTime() - rentalDate.getTime();
            this.duration = (int) (diff / ( 1000)); // Convert milliseconds to days
        }
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "RentalRecord{" +
                "rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", customer=" + customer +
                ", car=" + car +
                ", duration=" + duration +
                '}';
    }
}
