package com.workshop2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Customer {
    private String name;
    private String contactInformation;
    private List<RentalRecord> rentalHistory;

    public Customer(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.rentalHistory = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public List<RentalRecord> getRentalHistory() {
        return rentalHistory;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void setRentalHistory(List<RentalRecord> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public void addRentalRecord(RentalRecord rentalRecord) {
        rentalHistory.add(rentalRecord);
    }

    @Override
    public String toString() {
        return name + " (" + contactInformation + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) &&
                contactInformation.equals(customer.contactInformation);
    }


}
