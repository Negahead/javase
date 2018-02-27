package languagetopic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


/**
 * Autoboxing and unboxing is a convenient way to auto transform primitive
 * data type to it's corresponding java wrapper classes.
 *
 * compare objects with .equals() method when autoboxed,use == with caution
 *
 * frequently autoboxing and unboxing can create performance issues
 */
public class AutoBoxing {
    public static void main(String[] args) {
        String[] nums = {"0", "1", "2", "3", "4", "5"};
        Integer i = 1;
        Integer j = 1;
        if(i == j) {
            System.out.println("equal");
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for(String s : nums) {
            integers.add(Integer.valueOf(s));
        }
        System.out.println(Collections.binarySearch(integers,1,cmp));

        ChildO c = new ChildO();
        c.overrideMe();
    }

    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
        }
    };

    static void f(Object a, boolean b) {}
    static void f(Object a, Object b) {}
    static void m(int a, boolean b) {
        /**
         * the first phase performs overload resolution without permitting boxing and unboxing conversion,
         * if no applicable method is found during this phase then processing continues to the second phase.
         *
         * the second phase performs overload resolution while allowing boxing and unboxing,
         */
//        f(a,b);
    }

}

class SuperO {
    SuperO() {
        overrideMe();
    }
    public void overrideMe() {
        System.out.println("hello");
    }
}

class ChildO extends SuperO {
    private final Date date;

    ChildO() {
        this.date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }
}
