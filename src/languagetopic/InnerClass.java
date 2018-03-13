package languagetopic;

public class InnerClass {
    public static void main(String[] args) {
        /**
         * create a static nested class instance
         */
        Book.InsideBookStatic staticInner = new Book.InsideBookStatic();
        /**
         * you can not use A a = new A();
         */
        B b = new B();

        InnerClass innerclass = new InnerClass();
        /**
         * use new to create an inner class object.
         */
        InnerClass.A ib = innerclass.new A();
    }

    class A {

    }

    static class B {

    }
}

/**
 * java inner class is defined inside the body of another class,Java inner class can be declared
 * private,public,protected or with default access whereas an outer outer class can have only
 * public or default access.
 *
 * if a class is useful to only one class ,it makes sense to keep it nested and together,it helps
 * in packaging of the classes.
 *
 * java inner classes implements encapsulation,note that inner class can access outer class private
 * members and at the same time we can hide inner class from outer world,
 *
 * keep the small class with top-level classes places the code closer to where it is used and makes
 * code more readable and maintainable.
 *
 */

class Book {
    int i = 0;
    String name = "will";
    static String language = "Java";
    private String privateString = "private String";

    static void book() {
        System.out.println("static book method");
    }

    void regularMethod() {

    }

    private void privateMethod() {
        System.out.println("private method in outer class");
        int localInt = 100;
        /**
         * local class have access to the members of its enclosing class.
         * in addition,a local class can only access to local variables that are declared final.(till java 1.7)
         */
        class LocalClass {
            public void accessOuterClass() {
                System.out.println(name+privateString + localInt);
            }
        }
    }

    /**
     * Any non-static nested class is known as inner class in java,Java inner class is
     * associated with the object of the class and they can access all the variables
     * and methods of the outer class.
     */
    class InsideBook {
        int j = 100;
        String curse = "You Bitch";
        public void greeting() {
            System.out.println("hello bitch" + name + i);
            privateMethod();
        }
    }

    /**
     * static nested class,can only access static members(fields and methods) of the outer class.
     */
    static class InsideBookStatic {
        int k = 10;
        String lastName = "Turner";
        public void greeting() {
            System.out.println("hello Turner" + language);
            book();
//            regularMethod();
        }

    }
}
