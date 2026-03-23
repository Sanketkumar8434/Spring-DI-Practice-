# 🌱 Spring-DI-Practice

A hands-on practice repository exploring **Spring IoC (Inversion of Control)** and **Dependency Injection (DI)** patterns — from XML-based configuration all the way to 100% code-driven approaches.

---

## 📁 Project Structure

```
Spring-DI-Practice/
│
├── IocProj1/                    # Foundational IoC project (XML + Annotaion-based configuration)
├── IOCProj2/                    # Standard Spring IoC with XML + Annotaion-based configuration
├── IOCProj2 - 100p_code_Driven/ # 100% code-driven Configuration (no XML whatsoever)
└── IOC_Proj_CodeDriven_Config/  # 100% code-driven Configuration
```

### Project Summaries

| Project | Approach | Description |
|---|---|---|
| `IocProj1` | XML + Annotation-based Configuration| First IoC project; predefined java class beans defined in `applicationContext.xml` |
| `IOCProj2` | XML + Annotation-based Configuration| Second IoC project; predefined java class beans defined in `applicationContext.xml` |
| `IOCProj2 - 100p_code_Driven` | Pure Code | No XML; 100% annotation-driven DI with **Lombok** for boilerplate reduction |
| `IOC_Proj_CodeDriven_Config` | Java `@Configuration` | Explicit bean definitions via Java config classes |

---

## ⚙️ Setup & Installation

### Prerequisites

Make sure you have the following installed:

- **Java** 17 or higher
- **Maven** 3.6+ or **Gradle** 7+
- **IDE** — IntelliJ IDEA (recommended) or Eclipse/VS Code with Spring plugins
- **Git**

### Clone the Repository

```bash
git clone https://github.com/Sanketkumar8434/Spring-DI-Practice-.git
cd Spring-DI-Practice-
```

### Running a Project

Each subfolder is an independent Maven/Gradle project. Navigate into the desired project and run:

**With Maven:**
```bash
cd IocProj1
mvn clean install
mvn exec:java
```

**With an IDE:**
1. Open the project folder in IntelliJ IDEA (`File > Open`)
2. Let Maven/Gradle sync dependencies
3. Run the `main` class directly

### Dependencies

All projects use **`spring-context`** as the only explicitly declared Spring dependency. Adding this single dependency is enough — Maven automatically pulls in all transitively required Spring libraries (`spring-core`, `spring-beans`, `spring-aop`, `spring-expression`, etc.) needed for a basic Spring project.

```xml
<!-- Pulls in all core Spring dependencies transitively -->
 <!-- Source: https://mvnrepository.com/artifact/org.springframework/spring-context-support -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>7.0.5</version>
      <scope>compile</scope>
    </dependency>

<!--Note: The below all the dependencies mysql connector and Hickari CP is used in IOC PROJ-2 -->

<!-- Source: https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
    <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <version>9.4.0</version>
      <scope>compile</scope>
    </dependency>

<!-- Source: https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
    <dependency>
      <groupId>com.zaxxer</groupId>
      <artifactId>HikariCP</artifactId>
      <version>7.0.2</version>
      <scope>compile</scope>
    </dependency>
```

Additionally, **`IOCProj2 - 100p_code_Driven`** uses the **Lombok** library to eliminate boilerplate getter/setter code:

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.x</version>
    <scope>provided</scope>
</dependency>
```

> 💡 **Lombok Tip:** Annotate your bean classes with `@Getter` / `@Setter` (or `@Data` for all-in-one) and Lombok generates the boilerplate at compile time — keeping your code clean and concise.

---

## 📚 Concepts Covered

### 🔄 Inversion of Control (IoC)

IoC is a design principle where the control of object creation and lifecycle is transferred from the application code to the **Spring IoC Container**. Instead of your code doing `new MyService()`, Spring creates and manages it for you.

```
Traditional:       Your Code  →  creates  →  Objects
IoC:               Spring Container  →  injects  →  Objects into Your Code
```

### 💉 Dependency Injection (DI)

DI is the mechanism Spring uses to implement IoC. Dependencies are "injected" into a class rather than the class creating them itself.

**Three types of DI practiced in this repo:**

#### 1. Constructor Injection
```java
@Component
public class WishMessageGenerator {
    private final LocalDateTime localDateTime;

    @Autowired
    public WishMessageGenerator(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String generateMessage() {
        int hour = localDateTime.now().getHour();
        if (hour < 12) return "Good Morning!";
        else if (hour < 18) return "Good Afternoon!";
        else return "Good Evening!";
    }
}
```

#### 2. Setter Injection
```java
@Component
public class WishMessageGenerator {
    private LocalDateTime localDateTime;

    @Autowired
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String generateMessage() {
        int hour = localDateTime.now().getHour();
        if (hour < 12) return "Good Morning!";
        else if (hour < 18) return "Good Afternoon!";
        else return "Good Evening!";
    }
}
```

#### 3. Field Injection
```java
@Component
public class WishMessageGenerator {
    @Autowired
    private LocalDateTime localDateTime;

    public String generateMessage() {
        int hour = localDateTime.now().getHour();
        if (hour < 12) return "Good Morning!";
        else if (hour < 18) return "Good Afternoon!";
        else return "Good Evening!";
    }
}
```

---

### 🗂️ Configuration Approaches Explored

#### XML-Based Configuration (`IocProj1`)
Beans are declared in an XML file — the classic Spring way.
```xml
<bean id="localDateTime" class="java.time.LocalDateTime" factory-method="now"/>

<bean id="wishMessageGenerator" class="com.example.WishMessageGenerator">
    <property name="localDateTime" ref="localDateTime"/>
</bean>
```

#### Annotation-Based Configuration (`IOCProj2`)
Uses `@Component` and `@Autowired` to auto-detect and wire beans.
```java
@Component
public class WishMessageGenerator {

    @Autowired
    private LocalDateTime localDateTime;

    public String generateMessage() {
        int hour = localDateTime.now().getHour();
        if (hour < 12) return "Good Morning!";
        else if (hour < 18) return "Good Afternoon!";
        else return "Good Evening!";
    }
}
```

#### Java `@Configuration` Class (`IOC_Proj_CodeDriven_Config`)
Explicit bean wiring using Java — no XML, full control.
```java
@Configuration
public class AppConfig {

    @Bean
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    @Bean
    public WishMessageGenerator wishMessageGenerator() {
        return new WishMessageGenerator(localDateTime());
    }
}
```

#### 100% Code-Driven (`IOCProj2 - 100p_code_Driven`)
Pure annotation-driven approach with **Lombok** for getters/setters — no XML, no `@Configuration` class needed. Fully relies on component scanning.
```java
@Component
@Getter
@Setter
public class WishMessageGenerator {

    @Autowired
    private LocalDateTime localDateTime;

    public String generateMessage() {
        int hour = localDateTime.now().getHour();
        if (hour < 12) return "Good Morning!";
        else if (hour < 18) return "Good Afternoon!";
        else return "Good Evening!";
    }
}
```
```java
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx =
            new AnnotationConfigApplicationContext(AppConfig.class);
        WishMessageGenerator generator = ctx.getBean(WishMessageGenerator.class);
        System.out.println(generator.generateMessage());
    }
}
```

---

### 🧠 Key Spring Annotations Reference

| Annotation | Purpose |
|---|---|
| `@Component` | Marks a class as a Spring-managed bean |
| `@Autowired` | Injects a dependency automatically |
| `@Configuration` | Marks a class as a source of bean definitions |
| `@Bean` | Declares a bean inside a `@Configuration` class |
| `@Service` | Specialization of `@Component` for service layer |
| `@Repository` | Specialization of `@Component` for data access layer |
| `@ComponentScan` | Tells Spring where to scan for components |

---

## 🚀 Learning Progression

```
IocProj1  ──►  IOCProj2  ──►  IOC_Proj_CodeDriven_Config  ──►  IOCProj2 - 100p_code_Driven
  XML            Mixed              Java @Config                  Pure Annotations
(Classic)     (Hybrid)           (Explicit)                     (Modern Style)
```

---

## 🙌 Author

**Sanket Kumar**
- GitHub: [@Sanketkumar8434](https://github.com/Sanketkumar8434)

---

*Happy Coding! Keep Springing forward 🌿*
