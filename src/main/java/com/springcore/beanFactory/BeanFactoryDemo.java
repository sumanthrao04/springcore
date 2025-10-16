package com.springcore.beanFactory;

import com.springcore.bean.HelloService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryDemo {

    public static void main(String[] args) {
        System.out.println("=== BeanFactory Example ===");

        Resource resource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

        System.out.println("Bean definitions loaded. Beans are still not initialized.");
        HelloService helloService = beanFactory.getBean("helloService1", HelloService.class);
        helloService.sayHello();



    }

    /*XmlBeanFactory is deprecated since Spring 3.1, and completely discouraged in modern Spring (Spring 5+ / 6+).
        DefaultListableBeanFactory is the modern, flexible bean container.

        XmlBeanDefinitionReader loads bean definitions from an XML file.

        This is the modern equivalent of the old XmlBeanFactory
    * */
}
