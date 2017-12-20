package classes;

import annotations.MyCustomAnnotation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

@MyCustomAnnotation(name = "on top of class",address = "type annotation")
public class PersonReflect extends SuperClass{
    public PersonReflect(@MyCustomAnnotation(address = "in parameter",name = "parameter annotation") String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyCustomAnnotation(name = "in constructor",address = "constructor with 4 parameters")
    public PersonReflect(@MyCustomAnnotation(address = "in parameter",name = "parameter annotation")String name, int[] arrayOfInts, int age, String publicField) {
        this.name = name;
        this.arrayOfInts = arrayOfInts;
        this.age = age;
        this.publicField = publicField;
    }

    public PersonReflect() {
    }

    private String name;
    /**
     * Static field is effectively associated with the class object,which is in turn associated with a classloader,so if
     * two programs use separate classloader instances,you'll have two independent static variables.
     */
    private final static int SIZE = 5;
    private static int height = 170;
    private int[] arrayOfInts = new int[SIZE];
    @MyCustomAnnotation(name = "on top of age field",address = "field annotation")
    private int age;

    @MyCustomAnnotation(address = "Mountain 2",name = "will")
    public String publicField;

    @SuppressWarnings(value = "dfsdfdfgfdg")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    interface DataStructureIterator extends Iterator<Integer> {}

    public class EvenIterator implements DataStructureIterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Integer next() {
            return null;
        }
    }

    @MyCustomAnnotation(name = "method annotation",address = "on top of a method")
    private <T extends  Number> int greeting(@MyCustomAnnotation(name = "parameter annotation",address = "on top of a parameter")String greets,String name,T t) throws IOException,IndexOutOfBoundsException{
        class PhoneNumber {
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            // Valid in JDK 8 and later:

//            public void printOriginalNumbers() {
//                System.out.println("Original numbers are " + phoneNumber1 +
//                    " and " + phoneNumber2);
//            }
        }
        System.out.println(greets+" there " + name + t);
        return 1;
    }
}
