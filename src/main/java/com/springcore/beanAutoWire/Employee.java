package com.springcore.beanAutoWire;



public class Employee {
    private int id;
    private String name;
    private Address address; //  property name = address, property type = Address

    public Employee() {
        System.out.println("Employee object created (default constructor)");
    }

    // Constructor for constructor-based injection
    public Employee(Address address) {
        System.out.println("Employee object created (constructor injection)");
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Setter for Address (used in byName/byType)
    public void setAddress(Address address) {
        System.out.println("Setter called: Address injected into Employee");
        this.address = address;
    }

    public void showEmployeeDetails() {
        System.out.println("\n=== Employee Details ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        if (address != null) {
            address.displayAddress();
        } else {
            System.out.println("Address not injected!");
        }
    }
}
