package languagetopic;

/**
 * encapsulation is a technique that packages related data and behaviors into a single unit,
 * it is a technique for protecting data from misuse by outside world, which is referred as
 * information hiding or data hiding.In Java,encapsulation is done by using access modifiers
 * with classes,interface,setters,getters.
 *
 * paramount to understand encapsulation is the realization that it has two main objectives:
 *      hiding complexity
 *          encapsulation is inherently related to the concepts of modularity and abstraction
 *          deal with complexity by defining abstractions with public interfaces that we use
 *          to interact with them and all the unnecessary details get hidden under the hood of
 *          these abstraction.the beauty of abstraction is not having to understand all those
 *          details in order to be able to use it.the interface to a class should reveal as
 *          little as possible about its inner workings.
 *      hiding the sources of change
 *          changes can safely be done without affecting its public interface.if we achieve proper
 *          level of encapsulation in out software design we can safely foster change and evolution
 *          of our APIs without breaking its users.by this minimizing the impact of changes and
 *          the interdependence of modules,therefore,encapsulation is a way to achieve another
 *          important attributes of a good software design known as loose coupling.it decouples
 *          the modules that compromise a system,allowing them to be development because modules
 *          can be developed in parallel,it eases the burden of maintenance because modules
 *          can be understood more quickly and debugged with little fear of harming other modules.
 *
 *  Failing to define proper abstractions with proper levels of encapsulation will end up causing
 *  difficulties when change FINALLY happens,so encapsulation also helps us to minimize interdependence
 *  and facilitate change,we maximize encapsulation by minimizing the exposure of implementation details.
 *
 *  In a object-oriented programming language in Java,we achieve encapsulation by hiding details using the
 *  accessibility modifiers,the state of a class should only be accessed through its public interface.with
 *  these levels of accessibility we control the level of encapsulation,the less restrictive the level,the
 *  more expensive change is when it happens and the more coupled the class is with other dependent classes.
 */
public class Encapsulation {
}

/**
 * Person class is an encapsulation unit,A Person object exposes it attributes and behaviors to the
 * outside world.encapsulation hides implementation details of Person class from other objects.
 */
class Person {
    String name;
    int age;
    void talk() {

    }
    void think() {}
    void play() {}
    void work() {}
}

/**
 * creating an interface is also the process of encapsulation,
 */
interface Human {
    void talk();
    void think();
}
