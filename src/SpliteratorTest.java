import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by AlphaGo on 12/8/2017.
 */
public class SpliteratorTest {
    // Parallelism is a term that refers to programming in a way to exploit multi-core
    // cpu units.to take a piece of work and break it out into separate units that can be
    // processed in parallel.then aggregating the results of all the processed units to
    // complete the origin work.for this to be successful,the processing unit should not have
    // a dependency on any other unit,this process should be stateless and also should not
    // depend on the result of the processing of any other unit.parallel computing lends itself to
    // situations where vast amounts of data is to be handled.try keep each CPU core busy all the time.
    // Spliterator is a new special kind of iterator that can traverse a Collection
    // The spliterator can 'split' the Collection,partitioning of some of its elements as another
    // Spliterator,this does allow parallel processing of different parts of a Collection but Note
    // that the spliterator itself does not provide the parallel processing behaviour,instead,the
    // spliterator is there to support parallel traversal of the suitably partitioned parts of a
    // Collection
    public static void main(String[] args) {
//        System.out.println(Spliterator.CONCURRENT);// 4096
//        System.out.println(Spliterator.DISTINCT); // 1
//        System.out.println(Spliterator.IMMUTABLE); // 1024
//        System.out.println(Spliterator.NONNULL); // 256
//        System.out.println(Spliterator.ORDERED); // 16
//        System.out.println(Spliterator.SIZED); // 64
//        System.out.println(Spliterator.SORTED); // 4
//        System.out.println(Spliterator.SUBSIZED); // 16386

        List<Person> personList = new ArrayList<>();
        System.out.println(personList.spliterator().characteristics()); // ORDERED | SORTED | SUBSIZED
        System.out.println("estimate size is " + personList.spliterator().estimateSize()); // 0
        personList.add(new Person(22,134,"will"));
        personList.add(new Person(12,156,"tony"));
        personList.add(new Person(25,169,"stark"));
        personList.add(new Person(16,178,"liv"));
        personList.add(new Person(16,190,"james"));
        System.out.println("estimate size is " + personList.spliterator().estimateSize()); // 5
        System.out.println(personList.spliterator().characteristics()); // ORDERED | SORTED | SUBSIZED
        //Consumer<Person> c = p1->p1.setAge(p1.getAge()+1);
        personList.spliterator().forEachRemaining(((Consumer<Person>) p1->p1.setAge(p1.getAge()+1)).andThen(System.out::println));
        personList.spliterator().trySplit().forEachRemaining(System.out::println);




    }
}

class Person {
    private int age;
    private int height;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        Person p = (Person) obj;
        if(p.getAge() == this.getAge())
            flag = true;
        return flag;
    }

    @Override
    public int hashCode() {
        return this.getAge();
    }

    public Person(int age, int height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
