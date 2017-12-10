import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

/**
 * Created by AlphaGo on 12/6/2017.
 */
public class ListClassTest {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(10);
        intList.add(-100);
        intList.add(-3434);
        intList.add(4584);

//        Comparator<Integer> c = (a,b)-> {
//            if(a*2 < b )
//                return -1;
//            if(a*2 > b)
//                return 1;
//            return 0;
//        };

        intList.sort(Comparator.comparing((n)->-n*2));

        intList.forEach(System.out::println);
    }

}
