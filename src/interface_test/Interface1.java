package interface_test;

public interface Interface1 {

    // all fields in interface are public static final.they are constants.
    static final long l = 10L;

    /**
     * when a class will implement this interface,it is not mandatory to provide implementation
     * for default method of interface,this feature will help us in extending interfaces with
     * additional methods,all we need to do is to provide a default implementation.
     * @param name
     */
    default void greeting(String name) {
        System.out.println("hello there " + name);
    }

    /**
     * similar to default method except that you can't override them in the implementation class.
     *
     * java interface static method is part of interface,we can't use it for implementation
     * class objects.they are good for providing utility methods.
     *
     * @param str
     * @return
     */
    static boolean isNull(String str) {
        return str == null;
    }
}
