package com.springcore.config;

import com.springcore.bean.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springcore")
public class AppConfig {

    @Bean
    public HelloService helloService(){
        HelloService hs = new HelloService();
        hs.setMessage("Hello from @Configuration @Bean!");
        return hs;
    }
}
