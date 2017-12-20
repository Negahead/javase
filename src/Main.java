import annotations.MyCustomAnnotation;
import classes.PersonReflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(null);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(22,165,"will"));
        personList.add(new Person(100,180,"chris"));
        personList.add(new Person(234,165,"john"));
        personList.add(new Person(-34,144,"jane"));
        personList.add(new Person(45,135,"emma"));
        personList.add(new Person(22,180,"tony"));
        //personList.add(null);
        personList.sort(Comparator.<Person,Integer>comparing(p1->p1.getAge()).thenComparing(p2->p2.getHeight()));
        personList.forEach(System.out::println);


        /**
         * A call to Class.forName("X") causes the class named X to be dynamically loaded(at runtime),Class.forName("X")
         * returns the Class Object associated with the "X" class,the returned Class Object is not an inheritance of the "X" class itself.
         *
         *
         * calling clazz.newInstance() creates a new instance of the class represented by this Class Object,the class is instantiated as if
         * by a new expression with an empty argument.
         *
         *
         * when you write .class after a class name,it references the class literal-java.lang.Class Object that represents information
         * about given class.for Example,if your class is Print,then Print.class is an object that represents the class Print on runtime,
         * it is the same object that is returned by getClass() method.
         */
        Class clazz = Class.forName("classes.PersonReflect");
        System.out.println(clazz);
        Constructor[] constructor = clazz.getConstructors();
        for(Constructor c : constructor) {
            System.out.println(c);
        }

        System.out.println("===================");
        /**
         * why int.class? the JVM defines class Objects for each of the primitive types,
         * there are nine predefined Class Objects to represent the eight primitive types and void.
         */
        Constructor constructor2 = clazz.getConstructor(String.class,int.class);
        Constructor constructor4 = clazz.getConstructor(String.class,int[].class,int.class,String.class);
        // public classes.PersonReflect(java.lang.String,int)
        System.out.println(constructor2);
        // true
        System.out.println(constructor2.equals(constructor[0]));
        // public classes.PersonReflect(java.lang.String,int)
        System.out.println(constructor2.toGenericString());
        // false
        System.out.println(constructor2.isSynthetic());

        // 2
        System.out.println(constructor2.getParameterCount());
        // 4
        System.out.println(constructor4.getParameterCount());
        // classes.PersonReflect
        System.out.println(constructor4.getName());

        /**
         * returns the array of type parameters used in the method definition,It does not return the array
         * of argument types,Generic
         */
        for(TypeVariable t : constructor4.getTypeParameters()) {
            System.out.println(t.getName() + t.getTypeName());
        }

        /**
         * '@annotations.MyCustomAnnotation(age=18, name=in constructor, address=constructor with 4 parameters)'
         */
        for(Annotation a : constructor4.getDeclaredAnnotations()) {
            System.out.println(a.toString());
        }
        Annotation annotation = constructor4.getAnnotation(MyCustomAnnotation.class);
        System.out.println(annotation.toString());
        String name = PersonReflect.class.getAnnotation(MyCustomAnnotation.class).address();
        System.out.println("=>>>>>>>>>>>>>>>>"+name);
        /**
         * 1
         */
        System.out.println(constructor4.getModifiers());
        /**
         * classes.PersonReflect
         */
        System.out.println(constructor4.getDeclaringClass().getName());

        /**
         * false
         */
        System.out.println(clazz.isAnnotation());

        Class annotationClazz = Class.forName("annotations.MyCustomAnnotation");
        /**
         * true
         */
        System.out.println(annotationClazz.isAnnotation());
        /**
         * ' @annotations.MyCustomAnnotation(age=18, name=on top of class, address=type annotation),
         */
        for(Annotation a : clazz.getAnnotations()) {
            // type level annotation
            System.out.println(a.toString());
        }
        System.out.println("====================================");
        /**
         * classes.PersonReflect
         */
        System.out.println(clazz.getCanonicalName());

        /**
         * classes.PersonReflect.EvenIterator. All the public classes and interfaces that are members of the class represented by this Class Object
         */
        for(Class innerClass : clazz.getClasses()) {
            System.out.println(innerClass.getCanonicalName());
        }

        /**
         * ====================================================
         *  it is time about ClassLoader
         *      every Class object contains a reference to the ClassLoader that defines it
         */

        /**
         * ====================================================
         *  Field
         */
        System.out.println("field=========================================");
        /**
         *  get declared field,no mater public or private,
         *  Two Field objects are the same if they were declared by the same class and have the same name and type.
         */
        Field privateAgeField = PersonReflect.class.getDeclaredField("age");
        // "age"
        System.out.println(privateAgeField.getName());
        // "int"
        System.out.println(privateAgeField.getType().getCanonicalName());
        /**
         * without this,private field will report error
         */
        PersonReflect personReflect = new PersonReflect();
        privateAgeField.setAccessible(true);
        privateAgeField.setInt(personReflect,23);
        System.out.println(privateAgeField.get(personReflect));

        Field staticIntField = clazz.getDeclaredField("SIZE");
        staticIntField.setAccessible(true);

        // java.lang.Integer
        System.out.println(Integer.class.getTypeName());
        // classes.PersonReflect
        System.out.println(PersonReflect.class.getTypeName());
        // Integer
        System.out.println(Integer.class.getSimpleName());
        // java.lang.Integer
        System.out.println(Integer.class.getCanonicalName());
        // java.lang.Integer
        System.out.println(Integer.class.getName());
        // classes.PersonReflect
        System.out.println(privateAgeField.getDeclaringClass().getCanonicalName());
        // int
        System.out.println(privateAgeField.getType().getTypeName());
        // 5
        System.out.println(staticIntField.get(personReflect));
        // cannot set static final fields
        // System.out.println(staticIntField.get(personReflect));
        // "height" is private static int
        Field staticHeight = clazz.getDeclaredField("height");
        staticHeight.setAccessible(true);
        // 170
        System.out.println(staticHeight.get(personReflect));
        staticHeight.setInt(personReflect,1000);
        // 1000,so you can set static variables
        System.out.println(staticHeight.get(personReflect));

        /**
         * by the way:
         *      a.getClass() returns the runtime type of a. I.E.,if you have A a = new B(),then a.getClass() will return B class
         *      a.class evaluates to the A class statically ,and is used for other purpose often related to reflection
         */
        Field privateIntAge = PersonReflect.class.getDeclaredField("age");
        privateIntAge.setAccessible(true);
        System.out.println("set by annotation");
        // int
        String addressAnnotations = privateIntAge.getAnnotation(MyCustomAnnotation.class).address();
        // field annotation
        System.out.println(addressAnnotations);
        // null,
        //String differentAccess = privateIntAge.getAnnotatedType().getAnnotation(MyCustomAnnotation.class).address();
        // System.out.println(differentAccess);

        for(Annotation a : privateIntAge.getDeclaredAnnotations()) {
            System.out.println(a.annotationType().getCanonicalName());
        }

        AnnotatedType superClass = PersonReflect.class.getAnnotatedSuperclass();
        // classes.SuperClass
        System.out.println(superClass.getType().getTypeName());

        /**
         *  getAnnotations basically gets all annotations that are also inherited from the parent class.
         *  getDeclaredAnnotations get annotations declared only on the class.
         */


        /**
         *  getDeclaredMethod()
         */

        System.out.println("get declared method======================");
        PersonReflect personReflect1 = new PersonReflect();
        Method method = clazz.getDeclaredMethod("greeting", String.class, String.class,Number.class);
        // on top of a method
        System.out.println(method.getAnnotation(MyCustomAnnotation.class).address());
        // classes.PersonReflect
        System.out.println(method.getDeclaringClass().getName());
        // null
        System.out.println(method.getDefaultValue());
        // java.io.IOException
        // java.lang.IndexOutOfBoundsException
        for(Class c : method.getExceptionTypes()) {
            System.out.println(c.getTypeName());
        }
        // java.lang.String
        // java.lang.String
        // java.lang.Number
        for(Class c : method.getParameterTypes()) {
            System.out.println(c.getTypeName());
        }
        // java.lang.String
        // java.lang.String
        // T
        for(Type t : method.getGenericParameterTypes()) {
            System.out.println(t.getTypeName());
        }
        // int
        System.out.println(method.getGenericReturnType().getTypeName());
        // greeting
        System.out.println(method.getName());
        // private <T> int classes.PersonReflect.greeting(java.lang.String,java.lang.String,T) throws java.io.IOException,java.lang.IndexOutOfBoundsException
        System.out.println(method.toGenericString());
        // private int classes.PersonReflect.greeting(java.lang.String,java.lang.String,java.lang.Number) throws java.io.IOException,java.lang.IndexOutOfBoundsException
        System.out.println(method.toString());
        method.setAccessible(true);
        method.invoke(personReflect1,"hello","will",1);

        /**
         *  getPackage()
         */
        System.out.println("getPackage()=====================================");
        Package pack = clazz.getPackage();
        // classes
        System.out.println(pack.getName());


    }

//    void printCollection(Collection<Object> c) {
//        for(Object o : c) {
//            System.out.println(o);
//        }
//    }

//    static <R> void printCollection(Collection<R> c) {
//        for(R e : c) {
//            System.out.println(e);
//        }
//    }

    static void printCollection(Collection<? extends Number> c) {
        c.forEach(System.out::println);
    }
}

class Persons implements Comparable<Person>{
    private int age;
    private int height;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Persons(int age, int height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonReflect{" +
                "age=" + age +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        }
        if (this.age < o.getAge()) {
            return -1;
        }
        if (this.age == o.getAge()) {
            if (this.height > o.getHeight()) {
                return 1;
            }
            if (this.height < o.getHeight()) {
                return -1;
            }
            return 0;
        }
        return 0;
    }
}
