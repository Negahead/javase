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
        list.add(3);
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

    }
}
