import static utils.InputUtils.*;
import bank.*;  //need to learn how it worked in tutorial

// Mutable wrapper class for age
// class MutableAge {
//     int value;
//     MutableAge(int value) { this.value = value; }
//     public String toString() { return String.valueOf(value); }
// }

class Student {
    String name;
    int age; // Use mutable wrapper class for shallow copy

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(Student s) {
        this(s.name, s.age);
    }

    public void printInfo() {
        print("Name: " + this.name + " Age: " + this.age);
    }

    /*
     * Polymorphism -> Function Overloading -> Compile Time Polymorphism
     * public void printInfo(String name){
     * print("Name: " + name);
     * }
     * public void printInfo(String name, int age){
     * print("Name: " + name + " Age: " + age);
     * }
     * public void printInfo(Student s){
     * print("Name: " + s.name + " Age: " + s.age);
     * }
     */
};

// Single Level Inheritance
class Shape {
    public void display(){
        print("Displaying Shape");
    }
    public void area() {
        print("Area Printing...");
    }
}

class Triangle extends Shape {
    //Pollymorphism -> Function Overriding
    @Override
    public void display(){
        print("Displaying Triangle");
    }
    public void area(int l, int h) {
        print("Area : " + (1 / 2) * l * h);
    }
}

// Multi Level Inheritance
class EquilateralTriangle extends Triangle {
    public void area(int l, int h) {
        print("Area of Equilateral : " + (1 / 2) * l * h);
    }
}

// Hirarchal Inheritance
class Circle extends Shape {
    void area(int r) {
        print("Circle area: " + (3.14) * r * r);
    }
}
// Hybrid for mixing all


//Abstraction
abstract class Animal {
    Animal(){
        print("Animal Created");
    }
    abstract void walk();
    protected void eat(){
        print("Animal eats");
    }
}
class Horse extends Animal{
    Horse(){
        print("Horse Created");
    }
    public void walk(){
        print("Horse Walking");
    }
}
class Chicken extends Animal{
    public void walk(){
        print("Chicken Walking");
    }
}

//Abstraction with Interfaces
//Multiple inheritance is possible in interface too
interface Animal2{
    void walk();  //By default public in interface not default
    // Animal2(){} //No constructor allowed in interface
    // public void eat(){} //No function other than abstract ones allowed
}
interface Herbivore{
    void eat();
}
class Horse2 implements Animal2, Herbivore{
    static int legs;
    Horse2(){
        print("Horse 2 is created");
    }
    public void walk(){
        print("Horse2 is walking");
    }
    public void eat(){
        print("Eats Plants only");
    }

}


public class tut17 {

    public static void main(String[] args) {
        // Student s1 = new Student("Aashu", 21);
        // s1.printInfo();
        // Student s2 = new Student(s1);
        // s2.age = 22;

        // // Test shallow copy behavior
        // s2.name = "Bashu"; // This won't affect s1 (String is immutable)
        // s2.age.value = 22; // This WILL affect s1 because both reference the same
        // MutableAge object

        // print("After changing s2:");
        // s1.printInfo();
        // s2.printInfo();

        /*
         * Polymorphism -> Function Overloading -> Compile Time Polymorphism
         * s1.printInfo("Aashu");
         * s1.printInfo("Aashu", 21);
         * s1.printInfo(s2);
         */

        // Single Level Inheritance
        // Triangle t1 = new Triangle();
        // t1.area(3, 3);

        // Multi Level Inheritance
        // EquilateralTriangle t1 = new EquilateralTriangle();
        // t1.area(1, 6);

        // Hirarcheal Inheritance
        // Triangle t1 = new Triangle();
        // t1.area(3,4);
        // Circle c1 = new Circle();
        // c1.area(3);

        // Hybrid for mixing all


        //Encapsulation
        //Packages
        // Account a1 = new Account();  //Default not worked outside package
        // Bank b1 = new Bank(); //public one is working
        // b1.name = "Bank Ashesh";
        // // b1.email = "aashukumar@gmail.com";  //Protected not allowed 
        // // b1.number = "12345678";   //Default not available 
        // // b1.password = "@31425367"; //Private not availble
        // b1.setPassword("lqkwht527");
        // b1.printInfo();


        //Abstraction
        // Animal a = new Animal(); //Error on abstrack class object
        // Horse h = new Horse();
        // h.walk();
        // h.eat();
        // Chicken c = new Chicken();
        // c.walk();
        

        //Abstraction with Interfaces
        // Animal2 a = new Animal2(); //No interface object
        Horse2 h2 = new Horse2(); 
        Horse2.legs = 4;
        print("Horse2 legs: " + h2.legs);
        h2.walk();
        h2.eat();

    }
}