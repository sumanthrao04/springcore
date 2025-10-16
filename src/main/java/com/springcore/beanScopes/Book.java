package com.springcore.beanScopes;

public class Book {
    private String name;

    public Book() {
        System.out.println("Book instance created: " + this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Book Name: " + name + " | Instance: " + this);
    }
}