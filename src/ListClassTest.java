import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

/**
 * Created by AlphaGo on 12/6/2017.
 */
public class ListClassTest {
    /**
     *  ArrayList and Vector:
     *      public class ArrayList<E> extends AbstractList<E>
     *                                implements List<E>,RandomAccess,Cloneable,Serializable
     *
     *      public class Vector<E> extends AbstractList<E>
     *                                implements List<E>,RandomAccess,Cloneable,Serializable
     *
     *      public class CopyOnWriteArrayList<E> extends Object
     *                                implements List<E>,RandomAccess,Cloneable,Serializable
     *
     *
     *      Vector is synchronized while ArrayList is not.
     *      Internally,both the ArrayList and Vector hold onto their contents using an Array.When an
     *      element is inserted into an ArrayList or Vector,the object will need to expand its internal
     *      array if it runs out of room.A Vector defaults to doubling the size of its array,while the
     *      ArrayList increases its array size by 50 percent.
     *
     *      Vector is a broken class that is not thread safe,despite it being synchronized and is only used
     *      by students and other inexperienced programmers.
     *
     *      ArrayList is the go-to List implementation used by professionals and experienced programmers.
     *
     *      Professionals wanting a thread safe List implementation use a CopyOnWriteArrayList in
     *      java.util.concurrent package.
     */
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
