package interface_test;

public interface Interface2 {
    default void greeting(String name) {
        System.out.println("hello there " + name);
    }

}
