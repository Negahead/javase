package classes;


import annotations.MyCustomAnnotation;

@MyCustomAnnotation(name = "super class annotation",address = "on top of a superclass")
class SuperClass {
    public void hello(String name) {
        System.out.println("hello " + name);
    }
}
