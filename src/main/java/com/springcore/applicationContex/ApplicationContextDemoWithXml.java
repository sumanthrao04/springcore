package com.springcore.applicationContex;

import com.springcore.bean.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextDemoWithXml {

    public static void main(String[] args) {
        System.out.println("=== ApplicationContext Example ===");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("ApplicationContext created (beans are eagerly initialized).");

        HelloService helloService = context.getBean("helloService2", HelloService.class);
        helloService.sayHello();


        ((ClassPathXmlApplicationContext) context).close();
    }
}
