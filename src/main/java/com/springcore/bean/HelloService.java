package com.springcore.bean;

public class HelloService {

    private String message;

    public HelloService() {
        System.out.println("HelloService constructor called");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println("Message: " + message);
    }
}
