import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface Drawable {
    static void sv() {

    }
    void draw();
    default void deDraw() {}
    default void deDraww() {}
}

interface Drawable2 {
    int age = 244;
    static void greeting() {
        System.out.println("hello world");
    }
    void draw();
}

class Drawableimpl implements Drawable {

    @Override
    public void draw() {
        System.out.println("implementing draw() method" );
    }
}

interface Sayable {
    void say(String words);
}
public class Main {

    public static void main(String[] args) {
        Drawable d = () -> {
            System.out.println("Drawing...");
        };
        d.draw();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(3);
        list.add(4);

        list.stream().filter((n)->n > 5);
        list.forEach((n)->{
            System.out.println(n);
        });


    }
}
