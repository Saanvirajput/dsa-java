# ☕ Object-Oriented Programming (OOP) in Java
Resource: Striver's OOPS Series

## 📜 Introduction
Object-Oriented Programming (OOP) is a paradigm that organizes software design around **data** (objects) rather than logic. In Java, OOP is essential for building modular, scalable, and maintainable systems, especially when implementing complex Data Structures and Algorithms.

---

## 🏗️ Classes and Objects

- **Class**: A blueprint or template that defines the structure and behavior (data fields and methods) of an entity.
- **Object**: A specific instance of a class. Memory is only allocated when an object is instantiated.

### Access Specifiers
Controls the visibility of class members:
- `public`: Accessible from anywhere.
- `private`: Accessible only within the same class.
- `protected`: Accessible within the same package and by subclasses.
- **Default (Package-private)**: Accessible only within the same package.

---

## 🚀 The Entry Point: `main` Method

```java
class Basics {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

- **`static`**: Allows the JVM to run the method without instantiating the class.
- **`void`**: Indicates the method doesn't return any value.
- **`String[] args`**: Stores command-line arguments.

---

## ⚡ Static vs. Instance Members

- **Static Methods**: Belong to the class itself. Called using `ClassName.methodName()`. Ideal for utility functions.
- **Instance Methods**: Belong to an object. Require the `new` keyword for instantiation before use.

---

## 🛠️ Constructors
Special methods used to initialize objects. They have the same name as the class and no return type.

- **Default Constructor**: Provided by Java if no constructor is defined.
- **Parameterized Constructor**: Takes arguments to set initial state.
- **Constructor Overloading**: Multiple constructors with different parameters.

---

## 🏛️ The Four Pillars of OOP

### 1. Encapsulation (Data Hiding) 🔒
Bundling data and methods into a single unit and restricting direct access to internal state. 
- Use `private` fields and `public` getters/setters.

```java
class BankAccount {
    private int balance;  // Private variable (data hiding)

    // Public method to access the balance
    public int getBalance() {
        return balance;
    }

    // Public method to modify the balance
    public void setName(int newBalance) {
        balance = newBalance;
    }
}
```

### 2. Inheritance (Code Reuse) 🧬
One class (subclass) acquires the properties of another (superclass) using the `extends` keyword.

```java
// Base class
    class Vehicle {
        private String VehicleNumber;
        
        public Vehicle(String VehicleNumber) {
            this.VehicleNumber = VehicleNumber;
        }
        
        public void honk() {
            System.out.println("Honk !!!!!!!!!!!");
        }
        
        public void printVehicleNumber() {
            System.out.println(VehicleNumber);
        }
    }
    
    // Derived class
    class Car extends Vehicle{
        public Car(String CarNumber) {
            super(CarNumber);
        }
    }
    
    // Derived class
    class Bus extends Vehicle{
        public Bus(String BusNumber) {
            super(BusNumber);
        }
    }
    
    class Main {
        public static void main(String[] args) {
            Car car = new Car("AB12CD2345");
            car.printVehicleNumber();
            car.honk();
            
            Bus bus = new Bus("XY23MN5678");
            bus.printVehicleNumber();
            bus.honk();
        }
    }
```

### 3. Polymorphism (Many Forms) 🎭
Allows objects to behave differently based on their specific type.
- **Compile-time**: Method Overloading (same name, different params).
- **Runtime**: Method Overriding (subclass provides its own implementation of a parent method).

```java
// Base class
class Vehicle {
    private String VehicleNumber;
    
    public Vehicle(String VehicleNumber) {
        this.VehicleNumber = VehicleNumber;
    }
    
    public void honk() {
        System.out.println("Honk !!!!!!!!!!!");
    }
    
    public void printVehicleNumber() {
        System.out.println(VehicleNumber);
    }
}

// Derived class
class Car extends Vehicle{
    public Car(String CarNumber) {
        super(CarNumber);
    }
    
    @Override
    public void honk() {
        System.out.println("Car Honk !!!!!!!");
    }
}

// Derived class
class Bus extends Vehicle{
    public Bus(String BusNumber) {
        super(BusNumber);
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car("AB12CD2345");
        car.printVehicleNumber();
        car.honk();
        
        Bus bus = new Bus("XY23MN5678");
        bus.printVehicleNumber();
        bus.honk();
    }
}
```

### 4. Abstraction (Essential Features) 🗺️
Hiding internal complexity and showing only the necessary interface.
- **Abstract Class**: Cannot be instantiated; can have both abstract and concrete methods.

```java
abstract class Animal {
    // Abstract method (no implementation)
    abstract void sound();

    // Regular method
    void sleep() {
        System.out.println("This animal sleeps.");
    }
}

// Subclass providing implementation for abstract method
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks.");
    }
}
```

- **Interface**: A contract that defining *what* a class must do, but not *how*. (Supports multiple inheritance).

```java
interface Animal {
    void sound(); // Abstract method (no body)
}

// Class implementing the interface
class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks.");
    }
}
```