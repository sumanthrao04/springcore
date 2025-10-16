# 🌱 Spring Bean Auto-Wiring Modes — Complete Guide

### 📘 Overview
Spring **Auto-Wiring** allows the container to automatically inject dependencies between beans without explicitly specifying them in XML.

You can control this behavior using the `autowire` attribute in `<bean>` definition.

---

## ⚙️ Types of Auto-Wiring (XML Configuration)

| Mode | Meaning | Auto-Wiring Basis |
|------|----------|-------------------|
| `no` | No auto-wiring (manual wiring) | Manual property or constructor reference |
| `byName` | Match by bean **id name** | Bean ID = property name |
| `byType` | Match by **class type** | Bean type = property type |
| `constructor` | Match by **constructor argument type** | Constructor parameter = bean type |

---

## 🧩 Example Scenario

We have two classes:

### `Address.java`
```java
package com.example.autowire;

public class Address {
    private String city;
    private String state;

    public Address() {
        System.out.println("🏠 Address object created");
    }

    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }

    public void displayAddress() {
        System.out.println("📍 Address: " + city + ", " + state);
    }
}
```

---

### `Employee.java`
```java
package com.example.autowire;

public class Employee {
    private int id;
    private String name;
    private Address address;

    public Employee() {
        System.out.println("👤 Employee object created (default constructor)");
    }

    public Employee(Address address) {
        System.out.println("👤 Employee object created (constructor injection)");
        this.address = address;
    }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public void setAddress(Address address) {
        System.out.println("🔧 Setter called: Address injected into Employee");
        this.address = address;
    }

    public void showEmployeeDetails() {
        System.out.println("\n=== Employee Details ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        if (address != null)
            address.displayAddress();
        else
            System.out.println("⚠️ Address not injected!");
    }
}
```

---

### `MainApp.java`
```java
package com.example.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        // Select one configuration at a time:
        // String config = "beans-no.xml";
        // String config = "beans-byName.xml";
        // String config = "beans-byType.xml";
        String config = "beans-constructor.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        Employee emp = (Employee) context.getBean("employee");
        emp.showEmployeeDetails();
    }
}
```

---

## 🧾 XML Configurations

### 1️⃣ **Manual Wiring (`no`)**
```xml
<bean id="address" class="com.example.autowire.Address">
    <property name="city" value="Chennai"/>
    <property name="state" value="Tamil Nadu"/>
</bean>

<bean id="employee" class="com.example.autowire.Employee">
    <property name="id" value="101"/>
    <property name="name" value="Arun Kumar"/>
    <property name="address" ref="address"/>
</bean>
```

📘 **Explanation:**  
No automatic wiring; you must manually connect beans using `<property>` or `<constructor-arg>`.

---

### 2️⃣ **byName**
```xml
<bean id="address" class="com.example.autowire.Address">
    <property name="city" value="Bangalore"/>
    <property name="state" value="Karnataka"/>
</bean>

<bean id="employee" class="com.example.autowire.Employee" autowire="byName">
    <property name="id" value="102"/>
    <property name="name" value="Sneha R"/>
</bean>
```

📘 **Explanation:**  
Spring finds the `address` bean because the bean ID matches the property name `address`.

⚠️ **Risk:**  
If bean ID doesn’t match the property name, injection fails silently.

---

### 3️⃣ **byType**
```xml
<bean id="addr" class="com.example.autowire.Address">
    <property name="city" value="Hyderabad"/>
    <property name="state" value="Telangana"/>
</bean>

<bean id="employee" class="com.example.autowire.Employee" autowire="byType">
    <property name="id" value="103"/>
    <property name="name" value="Rahul Sharma"/>
</bean>
```

📘 **Explanation:**  
Spring matches bean **type (`Address`)** with Employee’s property **type (`Address`)**.

⚠️ **Risk:**  
If multiple `Address` beans exist, Spring throws `NoUniqueBeanDefinitionException`.

---

### 4️⃣ **constructor**
```xml
<bean id="address" class="com.example.autowire.Address">
    <property name="city" value="Pune"/>
    <property name="state" value="Maharashtra"/>
</bean>

<bean id="employee" class="com.example.autowire.Employee" autowire="constructor">
    <property name="id" value="104"/>
    <property name="name" value="Meena Iyer"/>
</bean>
```

📘 **Explanation:**  
Spring uses the constructor `Employee(Address address)` for injection.

⚠️ **Risk:**  
Fails if multiple beans of type `Address` exist or if there’s constructor ambiguity.

---

## 🧠 Comparison Summary

| Mode | Injection Type | Matching Rule | When to Use | Risk |
|------|----------------|----------------|--------------|------|
| `no` | Manual | None | When full control needed | Tedious |
| `byName` | Setter | Bean ID = Property Name | When naming is consistent | Name mismatch |
| `byType` | Setter | Bean Type = Property Type | When types are unique | Multiple beans cause conflict |
| `constructor` | Constructor | Constructor Param Type | When dependency mandatory | Ambiguity if multiple beans |

---

## 🧩 Example Outputs

| Config | Output (Console) |
|--------|------------------|
| `beans-no.xml` | Setter called manually; Address injected |
| `beans-byName.xml` | Setter called automatically; injected by name |
| `beans-byType.xml` | Setter called automatically; injected by type |
| `beans-constructor.xml` | Constructor injection message shown |

---

## 🧭 Best Practices

✅ Use `byName` or `byType` for small XML-based projects.  
✅ Use `constructor` for mandatory dependencies.  
✅ For modern Spring projects, prefer **annotations**:  
`@Autowired`, `@Qualifier`, `@Primary`, `@ComponentScan`.

---

### 🏁 Key Takeaway

| Mode | Control | Simplicity | Recommended For |
|------|----------|-------------|-----------------|
| `no` | Full manual | Low | Legacy XML projects |
| `byName` | Semi-auto | Medium | Consistent bean naming |
| `byType` | Auto | High | Unique type beans |
| `constructor` | Auto (strong) | High | Required dependencies |

---

🧾 **Next Step:**
Try the same setup using **Annotations (`@Autowired`, `@Qualifier`, `@Primary`)**  
→ It removes all XML and uses pure Java configuration.
