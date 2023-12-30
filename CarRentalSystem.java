package com.workshop2;
import java.util.*;

public class CarRentalSystem {

    private Map<String, Car> carDetails;
    private Map<String, Customer> customerManagement;
    private List<RentalRecord> rentalHistory;

    public CarRentalSystem() {
        this.carDetails = new HashMap<>();
        this.customerManagement = new HashMap<>();
        this.rentalHistory = new ArrayList<>();
    }

    // Car Management
    public void addCar(String registrationNumber, Car car) {
        carDetails.put(registrationNumber, car);
        System.out.println("Car added successfully: " + car);
    }

    public void updateCar(String registrationNumber, Car updatedCar) {
        if (carDetails.containsKey(registrationNumber)) {
            carDetails.put(registrationNumber, updatedCar);
            System.out.println("Car updated successfully: " + updatedCar);
        } else {
            System.out.println("Car not found: " + registrationNumber);
        }
    }

    public void deleteCar(String registrationNumber) {
        if (carDetails.containsKey(registrationNumber)) {
            carDetails.remove(registrationNumber);
            System.out.println("Car deleted successfully: " + registrationNumber);
        } else {
            System.out.println("Car not found: " + registrationNumber);
        }
    }

    // Customer Management
    public void addCustomer(String customerId, Customer customer) {
        customerManagement.put(customerId, customer);
        System.out.println("Customer added successfully: " + customer);
    }

    public void updateCustomer(String customerId, Customer updatedCustomer) {
        if (customerManagement.containsKey(customerId)) {
            customerManagement.put(customerId, updatedCustomer);
            System.out.println("Customer updated successfully: " + updatedCustomer);
        } else {
            System.out.println("Customer not found: " + customerId);
        }
    }

    public void deleteCustomer(String customerId) {
        if (customerManagement.containsKey(customerId)) {
            customerManagement.remove(customerId);
            System.out.println("Customer deleted successfully: " + customerId);
        } else {
            System.out.println("Customer not found: " + customerId);
        }
    }

    // Rent a Car
    public void rentCar(String customerId, String registrationNumber, Date rentalDate) {
        if (customerManagement.containsKey(customerId) && carDetails.containsKey(registrationNumber)) {
            Customer customer = customerManagement.get(customerId);
            Car car = carDetails.get(registrationNumber);

            if (carDetails.get(registrationNumber).isAvailable()) {
                RentalRecord rentalRecord = new RentalRecord(rentalDate, customer, car);
                rentalHistory.add(rentalRecord);
                carDetails.get(registrationNumber).setAvailable(false); // Mark car as rented
                customer.addRentalRecord(rentalRecord);
                System.out.println("Car rented successfully: " + car);

            } else {
                System.out.println("Car is not available for rent: " + car);
            }
        } else {
            System.out.println("Customer or Car not found");
        }
    }

    // Return a rented car
    public void returnCar(String customerId, String registrationNumber, Date returnDate) {
        if (customerManagement.containsKey(customerId) && carDetails.containsKey(registrationNumber)) {
            Customer customer = customerManagement.get(customerId);
            Car car = carDetails.get(registrationNumber);

            if (!carDetails.get(registrationNumber).isAvailable()) {
                RentalRecord rentalRecord = findRentalRecord(customer, car);
                if (rentalRecord != null) {
                    rentalRecord.setReturnDate(returnDate);
                    carDetails.get(registrationNumber).setAvailable(true); // Mark car as returned
                    System.out.println("Car returned successfully: " + car);
                } else {
                    System.out.println("No matching rental record found for this customer and car combination.");
                }
            } else {
                System.out.println("Car is not rented: " + car);
            }
        } else {
            System.out.println("Customer or Car not found");
        }
    }

    // View rental history by customer
    public void viewRentalHistoryByCustomer(String customerId) {
        if (customerManagement.containsKey(customerId)) {
            Customer customer = customerManagement.get(customerId);
            List<RentalRecord> customerRentalHistory = customer.getRentalHistory();
            System.out.println("Rental History for Customer: " + customer);
            for (RentalRecord record : customerRentalHistory) {
                System.out.println(record);
            }
        } else {
            System.out.println("Customer not found: " + customerId);
        }
    }



    // Helper method to find rental record by customer and car
    private RentalRecord findRentalRecord(Customer customer, Car car) {
        for (RentalRecord record : rentalHistory) {
            if (record.getCustomer().equals(customer) && record.getCar().equals(car) && record.getReturnDate() == null) {
                return record;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        Car car1 = new Car("Toyota", "Camry", 2022, "Blue", 250.0);
        Car car2 = new Car("Honda", "Accord", 2021, "Red", 220.0);

        carRentalSystem.addCar("ABC123", car1);
        carRentalSystem.addCar("XYZ456", car2);

        Customer customer1 = new Customer("John Doe", "123-456-7890");
        Customer customer2 = new Customer("Jane Doe", "987-654-3210");

        carRentalSystem.addCustomer("C1", customer1);
        carRentalSystem.addCustomer("C2", customer2);

        Date rentalDate = new Date();
        carRentalSystem.rentCar("C1", "ABC123", rentalDate);
        carRentalSystem.rentCar("C2", "XYZ456", rentalDate);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date returnDate = new Date();
        carRentalSystem.returnCar("C1", "ABC123", returnDate);
        carRentalSystem.returnCar("C2", "XYZ456", returnDate);

        carRentalSystem.viewRentalHistoryByCustomer("C1");

        carRentalSystem.deleteCustomer("C1");

        carRentalSystem.viewRentalHistoryByCustomer("C1");
        carRentalSystem.viewRentalHistoryByCustomer("C2");

    }
}
