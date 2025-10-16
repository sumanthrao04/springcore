package com.springcore.applicationContex;

import com.springcore.bean.GreetingService;
import com.springcore.bean.HelloService;
import com.springcore.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextJavaDemoWithAnnotation {

    public static void main(String[] args) {

            System.out.println("=== AnnotationConfigApplicationContext Example ===");

            AnnotationConfigApplicationContext ctx =
                    new AnnotationConfigApplicationContext(AppConfig.class);

            System.out.println("Context initialized (singleton beans eagerly created).");

            HelloService hello = ctx.getBean(HelloService.class);
            hello.sayHello();

        GreetingService helloSpring = ctx.getBean(GreetingService.class);
        helloSpring.sayGreet();
            ctx.close();
    }
}
