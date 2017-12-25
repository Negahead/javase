package classes;


import annotations.MyCustomAnnotation;

@MyCustomAnnotation(name = "super class annotation",address = "on top of a superclass")
class SuperClass {
    public void hello(String name) {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        System.out.println("HOME env is " + System.getenv("HOME"));
        String line = System.console().readLine("%s","enter a line of sentence");
        System.out.println("you just entered " + line);
    }
}
