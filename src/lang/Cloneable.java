package lang;

import java.util.HashMap;
import java.util.Map;

public class Cloneable {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.name = "will";
        myClass.props.put("age","23");
        myClass.props.put("job","no");
        /**
         * you get a compile time error:clone() has protected access in java.lang.Object
         *
         * you should:
         *      -- implement java.lang.Cloneable
         *      -- override method clone() of java.lang.Object.clone()
         */
        try {
            /**
             * default implementation of java code object is using shallow copy using reflection.
             * clone in java.lang.Object is protected native.
             *
             * use default Object.clone() method only when your class has primitive and immutable variables.
             * Utilize Object clone() method by calling super.clone() in overridden clone method,then make
             * necessary changes for deep coping mutable fields.
             *
             * if your class is serializable,you can use serialization too for cloning,However it will come with
             * a performance hit.
             */
            MyClass o = (MyClass) myClass.clone();

            System.out.println("class equality check ");
            System.out.println(o.getClass() == myClass.getClass()); // true

            /**
             * o and myClass are two different object,not referring to the same object.
             */
            System.out.println(o == myClass); // false
            System.out.println(o.equals(myClass)); // false

            /**
             * all the field equality check are true.
             */
            System.out.println(o.id == myClass.id); // true
            System.out.println(o.props == myClass.props); // true

            o.props.put("added by o","new");

            /**
             * this is a problem
             */
            System.out.println(myClass.props.get("added by o")); // new----> mutable field changes will affect the other

            o.name = "faker";
            /**
             * immutable field change in clone object will no change in the other one,
             * we are good with clone object default method as long as we have only
             * primitive and immutable fields in the object
             */
            System.out.println(myClass.name); // immutable
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * protected class makes no sense,protected class member(member or variable) is
 * just like package-private,except that is also can be accessed from subclasses.
 * since there is no such concept as subpackage,or package inheritance in Java,
 * declaring class as protected or package-private would be the same thing.
 */
class MyClass implements java.lang.Cloneable{
    final int id = 10;
    String name;
    Map<String,String> props = new HashMap<>();
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
