# Spring Core: BeanFactory vs ApplicationContext — Summary

## 🧩 Project Overview
This project demonstrates how **Spring manages beans** using two types of containers:
1. **BeanFactory** — the basic, lightweight container.
2. **ApplicationContext** — the advanced, enterprise-level container.

Both are responsible for **instantiating**, **configuring**, and **managing** beans defined in an XML configuration file.

---

## 🪜 What You Implemented
### 1. Maven Setup
- Created a **Maven project** in IntelliJ.
- Added the Spring Core dependency:
  ```xml
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>6.1.3</version>
  </dependency>
  ```

### 2. Bean Definition
Defined a simple POJO bean `HelloService` with:
- A message property.
- A method `sayHello()` to print the message.

### 3. XML Configuration
Created `beans.xml` to register the bean:
```xml
<bean id="helloService" class="com.example.beans.HelloService">
    <property name="message" value="Hello from Spring Bean!" />
</bean>
```

### 4. BeanFactory Demo
Used `XmlBeanFactory` to load and fetch beans:
```java
BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
HelloService helloService = (HelloService) factory.getBean("helloService");
helloService.sayHello();
```

- Beans are **lazily initialized** — created only when `getBean()` is called.

### 5. ApplicationContext Demo
Used `ClassPathXmlApplicationContext` to load and manage beans:
```java
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
HelloService helloService = context.getBean("helloService", HelloService.class);
helloService.sayHello();
```

- Beans are **eagerly initialized** at container startup.

---

## ⚖️ Key Differences

| Feature | BeanFactory | ApplicationContext |
|----------|--------------|--------------------|
| **Bean Initialization** | Lazy (on demand) | Eager (on startup) |
| **Performance** | Uses less memory | Loads faster at runtime |
| **Event Handling** | ❌ Not supported | ✅ Supported |
| **Internationalization (i18n)** | ❌ Not supported | ✅ Supported |
| **AOP, Annotations, etc.** | ❌ Limited | ✅ Fully supported |
| **Used In** | Simple, legacy apps | Modern enterprise & Spring Boot apps |
| **Recommended?** | ❌ Deprecated | ✅ Preferred |

---

## 🧠 Key Takeaways

- **`BeanFactory`** is the root container — minimal and lazy.
- **`ApplicationContext`** extends `BeanFactory` with extra enterprise features.
- **Spring loads beans** either lazily or eagerly depending on the container.
- **Configuration files (XML / Java)** tell Spring *what* to create and *how* to wire it.
- In modern Spring (and Spring Boot), **`ApplicationContext` is always used** under the hood.
- `XmlBeanFactory` is deprecated — **use `ApplicationContext` instead**.

---

## ✅ Next Step — Java-Based Configuration (No XML)

You extended this demo using **Java Configuration** instead of XML.

### 1. Create Configuration Class

📁 `src/main/java/com/example/config/AppConfig.java`
```java
package com.example.config;

import com.example.beans.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setMessage("Hello from Java-based configuration!");
        return helloService;
    }
}
```

### 2. Create Main Class Using `AnnotationConfigApplicationContext`

📁 `src/main/java/com/example/main/JavaConfigDemo.java`
```java
package com.example.main;

import com.example.beans.HelloService;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {
    public static void main(String[] args) {
        System.out.println("=== Java-based Configuration Example ===");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = context.getBean(HelloService.class);
        helloService.sayHello();

        ((AnnotationConfigApplicationContext) context).close();
    }
}
```

### 3. Output
```
=== Java-based Configuration Example ===
HelloService constructor called
Message: Hello from Java-based configuration!
```

### 4. Benefits of Java-Based Configuration

| Advantage | Description |
|------------|-------------|
| **Type-safe** | Uses Java classes and compiler checks |
| **No XML needed** | Cleaner, easier to maintain |
| **Supports Autowiring** | Works seamlessly with `@Autowired` |
| **Modern standard** | Used in Spring Boot and enterprise projects |

---

## 🏁 Final Learning Summary

- You learned how **Spring IoC (Inversion of Control)** containers work.
- Practiced both **XML** and **Java-based** bean configurations.
- Understood **lazy vs eager initialization**.
- Explored **container hierarchy** and the **evolution from BeanFactory → ApplicationContext → AnnotationConfigApplicationContext**.
- Gained hands-on clarity on how Spring manages beans behind the scenes.

---

**Author:** *You (Learner — Spring Core Basics)*  
**Purpose:** Understanding Spring Bean lifecycle and configuration styles (XML & Java).
