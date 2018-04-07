package interface_test;

public class MyClass implements Interface1,Interface2{
    public static void main(String[] args) {
        System.out.println(-16 >> 2); // -4
    }
    /**
     * now let's look at Interface1 and Interface2
     *
     * we know that java doesn't allow us to extend multiple classes because it will
     * result in the Diamond Problem,where compiler can't decide which superclass
     * method to use.with the default methods,the diamond problem would arise for \
     * interface too,Because if a class is implementing both Interface1 and Interface2,
     * and doesn't implement the common default method,the compiler can't decide which
     * one to chose.
     *
     * so it is mandatory to provide implementation for common default methods of interfaces,
     * if a class is implementing both the above interfaces,it will have to provide
     * implementation for greeting() method.
     *
     * one of the major reason for introducing default methods in interfaces is to enhance
     * the Collection API in JAVA 8 to support lambda expressions.
     *
     * A default method cannot override a method from java.lang.Object.
     */

    public void greeting(String name) {
    }

    public boolean isNull(String s) {
        return s==null;
    }
}
