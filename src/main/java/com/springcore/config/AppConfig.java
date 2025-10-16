package com.springcore.config;

import com.springcore.bean.HelloService;
import com.springcore.beanScopes.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.springcore")
public class AppConfig {

    @Bean
    public HelloService helloService(){
        HelloService hs = new HelloService();
        hs.setMessage("Hello from @Configuration @Bean!");
        return hs;
    }

    @Bean
    @Scope("singleton")
    public Book singletonBook() {
        Book book = new Book();
        book.setName("Singleton Book");
        return book;
    }

    @Bean
    @Scope("prototype")
    public Book prototypeBook() {
        Book book = new Book();
        book.setName("Prototype Book");
        return book;
    }
}
