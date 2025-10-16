package com.springcore.beanAutoWire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        //  Choose one config file at a time:
         String config = "beanAutoWire/beans-no.xml";
        // String config = "beanAutoWire/beans-byName.xml";
        // String config = "beanAutoWire/beans-byType.xml";
       // String config = "beanAutoWire/beans-constructor.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        Employee emp = (Employee) context.getBean("employee");
        emp.showEmployeeDetails();
    }
}

/* Notes

1-> no auto wire -> we have to define bean explicitly property in the xml
<property name="address" ref="address"/>

here  ref = address should match the bean id of address bean
<bean id="address" class="com.springcore.beanAutoWire.Address">
        <property name="city" value="Davangere"/>
        <property name="state" value="Karnataka"/>
    </bean>

2-> byName  ->  here filed name of the class (Employee class address filed )should match the bean id of address

 <bean id="address" class="com.springcore.beanAutoWire.Address">
        <property name="city" value="Shivamogga"/>
        <property name="state" value="Karnataka"/>
    </bean>
3-> By type -> class type -> Looks for a bean with same class type as the property.

4-> By constructor  -> it find constructor has an address parameter , it injects that values defined in xml file

Byname/Bytype -> uses setter injection
Byconstructor -> uses constructor injection

* */
