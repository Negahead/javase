package languagetopic;

import java.io.Serializable;

public class InheritanceTest {
    public static void main(String[] args) {
        /**
         * Static binding in Java occurs during compile time while dynamic binding during runtime.
         *
         * private,final,static(these methods can not be overridden) methods and variables use static binding and are bonded by compiler
         * while virtual methods are bonded during runtime based upon runtime object,
         *
         * static binding uses Type(a class in Java) information for binding while dynamic binding
         * uses object to resolve binding
         *
         * overloaded methods are bonded using static binding while overridden methods are bonded
         * using dynamic binding at runtime.
         */
//        Super s = new Child();
//        s.play();
//        s.dopa();
//
//        Child c = new Child();
//        s.dopa();

        Child c = new Child();
    }
}

class Super {
    Super() {
        play();
    }
    protected void dopa() {
        System.out.println("hello,I am Dopa");
    }
    int age = 23;
    public void play() {
        System.out.println("super class play");
    }

}

class Child extends Super {
    @Override
    public void play() {
        System.out.println("child class play");
    }

    public void greeting() {
        System.out.println("hello will" + age);
    }

}

/**
 * abstract class can't be instantiated,it contains one or more abstract method,An abstract method
 * is a method that is declared but contains no implementation,Abstract class requires subclasses
 * to provide implementations for the abstract methods.
 *
 * if a class have abstract methods,the the class should also be abstract using abstract keyword,
 * else it will not compile.
 *
 * it is not necessary to have abstract class to have abstract method.
 *
 * if abstract class doesn't have any method implementation,it is better to use interface instead.
 *
 * All the methods in an interface are implicitly abstract unless the interface methods are static
 * or default.they cannot have implementations,
 *
 * Java abstract class can implement interfaces without even providing the implementation of interface
 * methods.
 *
 * we can run abstract class in java like any other class if it has main() method.
 *
 * variable defined in interface are :public static final
 *
 * method in an interface is public by default                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
 *
 */

abstract class dopa {}
abstract class faker{}
abstract class AbstractClass {
    /**
     * a method that is declared as abstract and does not have implementation.
     */
    abstract void printStatus();

    public static void hello() {
        System.out.println("hello");
    }
}

/**
 * not static block in interface.because interface is not supply implementation.A block would
 * constitute implementation.Also,interface is not a part of object hierarchy.
 */
interface a {
    int b = 100;
}

/**
 * why multiple implementation and single inheritance
 */

/**
 * A child class redefine the instance methods (not static) methods of its parent class,this is called
 * method overriding.the parameter signature must be the same as defined in the parent class.method overriding
 * is done to achieve runtime polymorphism.
 *
 * polymorphism allows you to define one interface and have multiple implementations,this is one of the
 * basic concept of object-oriented programming,in Java,It describes a language's ability to process
 * objects of various types and classes through a single,uniform interface.
 */
