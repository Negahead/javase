import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(199);
        list.add(1);
        list.add(200);
        list.add(4);
        list.add(1);
        list.add(9);

        Collections.sort(list);
        // original list is changed
        list.stream().forEach(System.out::println);
        String s = "";
        for(int i : list) {
            s += "^".concat(String.valueOf(i));
        }

        s = s.substring(1);
        System.out.println(s);

        list.forEach(System.out::println);


        /**
         * The list must be sorted into ascending order according to the natural ordering of its elements (as by the sort(List) method) prior to making this call. If it is not sorted, the results are undefined.
         */
        System.out.println("index is " + Collections.binarySearch(list,3));

        /**
         * Replaces all of the elements of the specified list with the specified element.
         */
        //Collections.fill(list,100);

        System.out.println("fill");
        list.forEach(System.out::println);

        /**
         * frequency of the specified object
         */
        System.out.println("frequency of 1 is "+Collections.frequency(list,1));

        Collections.rotate(list,2);
        list.forEach(System.out::println);

    }
}
