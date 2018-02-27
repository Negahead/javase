package languagetopic;

public class BasicConcept {
    public static void main(String[] args) {
        /**
         * why String is immutable in Java?
         *      String pool(String intern pool) is a special storage in Java Heap,when
         *      a String is created and if the string already exists in the poll, the
         *      reference of the existing string will be returned,instead of creating a
         *      new Object and returning its reference.So if string is not immutable,
         *      changing the string with one reference will lead to the wrong value for
         *      other references.
         *
         *      String s1 = "hello",then an object will be created in String pool and s1
         *      will be pointing to hello,now if again we do String s2 = "hello",then another
         *      object will not be created but s2 will point to hello because JVM will
         *      first check if the same object is present in String pool or not,if not present
         *      then only a new one is created else not.
         *
         *      (caching)The hashcode of String is frequently used in Java,for Example,in a HashMap,
         *      Being immutable guarantees that hashcode will always be the same,so that it
         *      can be cashed without worrying the changes.
         *      (security)parameters are typically presented as String in network connections,data
         *      base connection urls,it it were mutable,these parameters could be easily changed.
         *      (Synchronization)make String immutable automatically makes them thread safe thereby
         *      solving the synchronization problems.
         *      (class loading)String is used as arguments for class loading,if mutable,it could
         *      result in wrong class being loaded.
         *
         *
         */
        String name = "will";
        String name2 = "will";
        String name3 = new String("will");
        /**
         * what is Java String pool?
         *      String pool in Java is a pool of Strings stored in Java Heap Memory,
         *      when we use double quotes to create a String,it first looks for String with same
         *      value in the String pool,if found it just return the reference else it creates a new
         *      String in the pool and returns the reference.
         *
         *      However,using new operator,we force String class to create a new String object in
         *      heap space.
         *
         *      so how many string is getting created in below statement:
         *          String str = new String("Cat");
         *      in the above statement,either 1 or 2 string will be created,if there is already a
         *      string literal "Cat" in the pool,then only one string "str" will be created in the
         *      heap space,if there is no string literal "Cat" in the pool,then it will be the first
         *      created in the pool and then in the heap space,so total 2 string objects will
         *      be created.
         *
         *      the String pool is the JVM's particular implementation of the concept of string interning:
         *          in computer science,string interning is a method of storing only one copy of each
         *          distinct string value,which must be mutable,Interning strings makes some processing
         *          tasks more time- and space-efficient at the cost of requiring more time when the
         *          string is created or interned,the distinct values are stored in a String intern pool.
         */


        /**
         * Java Heap Space:
         *      Java Heap space is used by java runtime to allocate memory to Objects and JRE classes,
         *      whenever we create any object,it is always created in the heap space.Garbage collection
         *      runs on heap memory to free the memory used by objects that doesn't have any
         *      reference,Any object created in the heap space has global access and can be referenced
         *      from anywhere of the application.
         */

        /**
         * Java Stack Memory:
         *      Java Stack Memory is used for execution of a thread.They contain method specified values
         *      that are short-lived and references to other objects in the heap that are getting referred
         *      from the method.
         *      stack memory in always references in LIFO order,whenever a method is invoked, a new bloc
         *      is created in the stack memory for the method to hold local primitive values and reference
         *      to other objects in the method.as soon as the method ends,the block becomes unused and
         *      become available for next method,stack memory size is very less to Heap memory.
         */

        /**
         * Difference between Java Heap Space and Stack Memory:
         *      Heap memory is used by all the parts of the application whereas stack memory is used only by
         *      one thread of execution
         *
         *      whenever an object is created,it's always stored in the Heap space and stack memory contains
         *      the reference to it,stack memory only contains local primitive variable and reference
         *      variable to objects in heap space.
         *
         *      Objects stored in the heap are globally accessible whereas stack memory can't be accessed
         *      by other threads.
         *
         *      Memory management in stack is done in LIFO manner whereas it is more complex in Heap memory
         *      because it 's used globally,Heap memory is divided into Young-Generation ,Old-Generation
         *      etc
         *
         *      Stack memory is short lived whereas heap memory lives from the start till the end of
         *      application execution.
         *
         *      when stack memory is full,Java runtime throws java.lang.StackOverFlowError whereas if heap
         *      memory is full,it throws java.lang.OutOfMemoryError.
         */

        /**
         * Java garbage collection:
         *      Automatic garbage collection is the process of looking at heap memory,identifying
         *      which objects are in use and which are not,and deleting the unused objects,as in
         *      use object,or a referenced objects,means that some part of your program still
         *      maintains a pointer to that object,an unused object,or unreferenced object,is no
         *      longer referenced by any part of your program,so the memory used by an
         *      unreferenced object can be reclaimed.
         *
         *
         *      Marking:
         *          garbage collector identifies which piece of memory are in use and which are not
         *
         *      Normal deletion:
         *          Normal deletion removes unreferenced objects leaving references objects and
         *          pointers to free space.
         *          Memory allocator holds a list of references to free spaces.and searches for free
         *          space whenever an allocation is required.
         *      Deletion with Compacting:
         *          To further improve performance,in addition to deleting unreferenced objects,you can
         *          also compact the remaining referenced objects,By moving referenced objects
         *          together,this makes new memory allocation much easier and faster.
         *
         *      Heap is broken up into smaller parts or generations,the heap parts are Young-Generation,
         *      Old or Tenured Generation and Permanent Generation:
         *          The Young Generation is where all new objects are allocated and aged,when the young
         *          generation fills up,this cause a minor garbage collection,minor collections can be
         *          optimized assuming a high object mortality rate
         *
         *          Stop the World Event - All minor garbage collections are "Stop the World" events.
         *          This means that all application threads are stopped until the operation completes.
         *          Minor garbage collections are always Stop the World events.
         *
         *          The Old Generation is used to store long surviving objects. Typically, a threshold is
         *          set for young generation object and when that age is met, the object gets moved to the
         *          old generation. Eventually the old generation needs to be collected. This event is called
         *          a major garbage collection.
         *
         *          The Permanent generation contains metadata required by the JVM to describe the classes
         *          and methods used in the application. The permanent generation is populated by the
         *          JVM at runtime based on classes in use by the application.
         *
         *          An allocation simply claims some portion of a memory array and moves the offset pointer forward
         *          The next allocation starts at this offset and claims the next portion of the array.
         *          When an object is no longer used, the garbage collector reclaims the underlying memory and
         *          reuses it for future object allocation. This means there is no explicit deletion and no memory
         *          is given back to the operating system.
         *      All objects are allocated on the heap area managed by the JVM. Every item that the developer uses is treated this way,
         *      including class objects, static variables, and even the code itself.
         *
         *      Every object tree must have one or more root objects. As long as the application can reach those roots,
         *      the whole tree is reachable. But when are those root objects considered reachable? Special objects called
         *      garbage-collection roots are always reachable and so is any object that has a garbage-collection root at its own root.
         *
         *      There are four kinds of GC roots in Java:
         *          Local variables are kept alive by the stack of a thread. This is not a real object virtual reference
         *          and thus is not visible. For all intents and purposes, local variables are GC roots.
         *
         *          Active Java threads are always considered live objects and are therefore GC roots. This is especially
         *          important for thread local variables.
         *
         *          Static variables are referenced by their classes. This fact makes them de facto GC roots. Classes themselves
         *          can be garbage-collected, which would remove all referenced static variables
         *
         *          JNI References are Java objects that the native code has created as part of a JNI call.
         */


        /**
         * Names of locals are resolved during compilation. Each variable becomes simply i-th variable in method and it
         * will be stored as i-th variable in stack frame of some method call.
         *
         * For instance variables it will be different. Field names are always present in bytecode (but will generally
         * not be present in machine code generated by JIT compiler). All objects of given class have the same layout,
         * so class can store offset of given field - distance from beginning of the object. Interpreter can read the
         * address of object and add offset to calculate where is variable stored.
         *
         * A name that is completely constrained to a block of code has allocated storage for the reference, on the stack frame,
         * which is on a Stack that is private to the Thread.
         *
         * A name that is a member of a class has allocated storage for the reference in the heap, within the Object that
         * represents the instance of that class.
         *
         * A name that is a static member of a class has allocated storage for the reference in the heap, within the Object
         * that represents the instance of the Class Object of that class.
         */

        /**
         * Java Method Area:
         *      Inside a Java Virtual Machine instance,information about loaded types is stored in a logical area of
         *      memory called the method area,the method area is created on java virtual machine start-up,
         *      it stores per-class structures such as the run-time constant pool,field and method data and the
         *      code form methods and constructors,when
         *      java Virtual Machine load a type,it uses a class loader to locate the appropriate class file,the
         *      class loader reads the class file,a linear stream of binary data and passes it to the virtual machine,
         *      the virtual machine extracts information about the type from the binary data and stores the information
         *      in the method area,Memory for static variable declared in the class is also taken from the method area.
         *      although the method area is logically part of the heap,simple implementations may choose not to
         *      either garbage collect or compact it.
         */

        /**
         * java passes parameter by value,passes references by value,Java manipulates objects
         * 'by reference',but it passes object references to methods 'by value'
         */
        System.out.println(10/3);
        System.out.println(10%3);
        B b = new B();
        C c = new C();
        D d = new D();
    }
}

class A {
    /**
     * Constructors in Java java have one purpose in life: to create an instance of a class,
     * This can also be called creating an object
     *
     * constructors takes only access modifiers(public,protected,private)
     *
     * constructors have no return type,not even void.
     *
     * A method uses this to refer to the instance of the class that is executing the method.
     * static method or static block do not use THIS,they do not belong to a class instance.
     * A constructor use this to refer to another constructor in the same class with a different
     * parameter list.we can use super and this in anywhere except static area.
     *
     * methods use super to execute an overridden method in the superclass,constructors use super
     * to invoke the supper class's constructor.must be the first line.
     *
     * Java methods are inherited,constructors are not.
     */
    A() {
        System.out.println("invoking A's default constructor");
    }

    static String h = "hello";
    static void greeting() {
        System.out.println();
    }
    protected void home(String name) {
        System.out.println("home sweet home " + name);
    }

}

class A2 {
    A2(String name) {
        System.out.println("invoking A2's default constructor");
    }
}

class F extends A2 {
    F() {
        /**
         * invoking supper class's constructor,must be the first line.
         */
        super("will");
    }
}

class SuperTest {
    SuperTest() {
        /**
         * inherit from Object class.
         */
        super();
    }
}

class B extends A {
    /**
     * base class's constructor in invoked first.(default)
     */
    B() {
        System.out.println("invoking B's default constructor");
        /**
         * invoking super class's method.
         *
         * super can be used to refer immediate parent class instance variable,
         * super can be used to invoke immediate parent class method,
         * super() can be used to invoke immediate parent class constructor(first line).
         */
        super.home("will");
        super.greeting();
    }
}

class C extends A {
    /**
     * base class's constructor is always constructed,one way or another
     */
}

class D extends B {
    D() {
        System.out.println("invoking D's default constructor");
    }
}
