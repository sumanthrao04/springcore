package com.springcore.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    private final HelloSpring helloSpring;

    @Autowired
    public GreetingService(HelloSpring helloSpring) {
        this.helloSpring = helloSpring;
    }

    public void sayGreet(){
        System.out.println("This is from Greek Method");
        helloSpring.getHelloMessage();
    }
}
