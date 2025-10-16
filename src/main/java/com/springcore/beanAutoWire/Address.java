package com.springcore.beanAutoWire;

public class Address {
    private String city;
    private String state;

    public Address() {
        System.out.println("Address object created");
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void displayAddress() {
        System.out.println("Address: " + city + ", " + state);
    }
}