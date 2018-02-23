import POJO.InvoiceDetail;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
        personList.add(new Person(2,156,"tony"));
        personList.add(new Person(25,169,"stark"));
        personList.add(new Person(16,178,"liv"));
        personList.add(new Person(17,190,"james"));

        int[] intArray = new int[] {23,100,1,34,6,-23,12,5,33,-45};

        Predicate<Person> p = p1->p1.getAge()>=22;
        List<Person> filtedPerson = personList.stream().filter(p.and(p2->p2.getHeight()>=156).negate()).collect(Collectors.toList());
        //filtedPerson.forEach(System.out::println);

        List<Integer> result = personList.stream().map((t)->{
            return t.getAge();
        }).collect(Collectors.toList());

        result.stream().forEach(System.out::println);

        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter((e) -> e.length() > 3)
                .peek((e) -> System.out.println("filtered value are " + e))
                .map(String::toUpperCase)
                .peek((e) -> System.out.println("mapped value: " + e))
                .collect(Collectors.toList());

        System.out.println(Optional.empty().isPresent());
        System.out.println(Optional.of(2).get());
        System.out.println(Optional.empty().orElse(100));

        List<String> s = new ArrayList<>();
        s.add("2017-01-01");
        s.add("2017-01-03");
        s.add("2017-01-05");
        s.add("2016-12-12");
        List<String> collect1 = s.stream().sorted().collect(Collectors.toList());
        collect1.forEach(System.out::println);

        List<InvoiceDetail> l = new ArrayList<>();
        l.add(new InvoiceDetail(1,"a","sdddfg"));
        l.add(new InvoiceDetail(0,"b","sdddfg"));
        l.add(new InvoiceDetail(1,"c","sdddfg"));
        l.add(new InvoiceDetail(0,"d","sdddfg"));
        l.add(new InvoiceDetail(1,"e","sdddfg"));
        l.add(new InvoiceDetail(0,"f","sdddfg"));
        l.add(new InvoiceDetail(1,"g","sdddfg"));
        l.stream().sorted( (  (Comparator.comparingInt(InvoiceDetail::getDetailId)))
        .thenComparing(Comparator.comparing(InvoiceDetail::getInvoiceNo))).forEach(System.out::println);

        Date d = new Date();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(d));

    }
}

