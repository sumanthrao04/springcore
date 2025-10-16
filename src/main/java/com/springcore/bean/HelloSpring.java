package com.springcore.bean;

import org.springframework.stereotype.Component;

@Component
public class HelloSpring {

    private  String helloMessage;

    public HelloSpring() {
        System.out.println("HelloSpring constructor called");
    }

    public void  getHelloMessage() {
        System.out.println("This is from HelloSpring ");
    }





    @Override
    public String toString() {
        return "HelloSpring{" +
                "helloMessage='" + helloMessage + '\'' +
                '}';
    }
}


/*Notes

@Component tells what should be a bean.
@Configuration + @ComponentScan (like your AppConfig class) tells where to look for those beans.

Without the configuration class, Spring wouldn’t know which package(s) to scan for @Component classes — unless you’re using Spring Boot, which auto-scans the main package.

In Spring Boot, you typically don’t need AppConfig because:

The @SpringBootApplication annotation already includes @ComponentScan.

It automatically scans the package where your main class is located and all its subpackages.
*
* */