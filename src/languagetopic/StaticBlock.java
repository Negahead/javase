package languagetopic;

/**
 * static block in java is executed only once,the first time you make an object of that class
 * or the first time you access a static member of that class.also,static block is executed
 * before constructors
 */
public class StaticBlock {
    private static int age;
    private String name;

    /**
     * the run time system guarantees that static initialization blocks are called in the order that they appear
     * in the source code,and the code will be executed when JVM load the class.you cannot use 'this' keyword
     * since there is no instance.also known as 'class initializer'
     */
    static {
        age = 22;
        System.out.println("static age variable is now " + age);
    }
    static {
        System.out.println("static block number 2");
    }

    /**
     * instance initializer
     */
    {
        // this code is executed before every constructors
        System.out.println("initializer blocks");
    }

    StaticBlock() {
        System.out.println("constructing an object");
    }
    public static void main(String[] args) {
        StaticBlock s = new StaticBlock();
    }
}
