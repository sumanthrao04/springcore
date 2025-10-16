package com.springcore.beanScopes;

import com.springcore.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=== Singleton Scope Test ===");
        Book singleton1 = ctx.getBean("singletonBook", Book.class);
        Book singleton2 = ctx.getBean("singletonBook", Book.class);
        singleton1.display();
        singleton2.display();
        System.out.println("Are both singleton beans same : " + (singleton1 == singleton2));

        System.out.println("\n=== Prototype Scope Test ===");
        Book prototype1 = ctx.getBean("prototypeBook", Book.class);
        Book prototype2 = ctx.getBean("prototypeBook", Book.class);
        prototype1.display();
        prototype2.display();
        System.out.println("Are both prototype beans same : " + (prototype1 == prototype2));

        ctx.close();
    }
}
