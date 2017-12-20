import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by AlphaGo on 12/9/2017.
 */
public class StreamClassTest {
    // Streams and Collections have different goals,Collections are primarily concerned with the efficient
    // management of,and access to their elements,By contrast,streams do not provide a means to directly access
    // of manipulate their elements,and are instead concerned with declaratively  describing their source and
    // the computational operations which will performed in aggregate on that source.



    //the default implementation of hashCode() provided by Object is derived by mapping the
    //memory address to an integer value
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(22,134,"will"));
        personList.add(new Person(22,156,"tony"));
        personList.add(new Person(25,169,"stark"));
        personList.add(new Person(16,178,"liv"));
        personList.add(new Person(16,190,"james"));

        Predicate<Person> p = p1->p1.getAge()>=22;
       List<Person> filtedPerson = personList.stream().filter(p.and(p2->p2.getHeight()>=156).negate()).collect(Collectors.toList());
        filtedPerson.forEach(System.out::println);

    }
}

