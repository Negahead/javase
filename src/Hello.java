public class Hello {
    static {
        System.out.println("static block");
    }

    public void greeting(String name) {
        System.out.println("Greetings " + name);
    }
}
