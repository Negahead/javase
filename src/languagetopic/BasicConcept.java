package languagetopic;

public class BasicConcept {
    public static void main(String[] args) {
        /**
         * why String is immutable in Java?
         *      String pool(String intern pool) is a special storage in Java Heap,when
         *      a String is created and if the string already exists in the pool, the
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
         *          distinct string value,which must be immutable,Interning strings makes some processing
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
         *          together,this makes new memory allocation much easier and faster.(Bump-the-pointer)
         *
         *      Heap is broken up into smaller parts or generations,the heap parts are Young-Generation,
         *      Old or Tenured Generation and Permanent Generation(method area):
         *
         *          The Young Generation is where all new objects are allocated and aged,when the young
         *          generation fills up,this cause a minor garbage collection,minor collections can be
         *          optimized assuming a high object mortality rate
         *
         *          Stop the World Event - All minor garbage collections are "Stop the World" events.
         *          This means that ==all application threads are stopped until the operation completes==.
         *          Minor garbage collections are always Stop the World events.
         *
         *          Stop-the-world will occur no matter which GC algorithm you choose,Stop-the-world means that
         *          the JVM is stopping the application from running to execute a GC,when stop-the-world occurs,
         *          every thread except for the threads needed for the GC will stop their task,the interrupted
         *          tasks will resume only after the GC tasks has completed,GC tuning often means reducing
         *          this stop-the-world time.People can set the relevant object to null or use System.gc() method
         *          to remove memory explicitly,Setting it to null is not a big deal,but calling System.gc() method
         *          will affect the system performance drastically(why?,A typical GC algorithm identifies garbage
         *          by traversing all non-garbage objects in the heap,and inferring that any object not visited
         *          must be garbage,From this ,we can model the total work of a garbage collection consists of
         *          one part that is proportional to the amount of live area,and another part that is proportional
         *          to the amount of garbage,i.e. work = (live * w1 + garbage * w2),to make the GC as efficient
         *          as possible,we need to maximize the value of the garbage when we run GC,i.e. wait util the
         *          heap is full,if the application does not interfere(by calling System.gc),the GC will wait util
         *          the heap is full before running,resulting the efficient collection of garbage,by if the
         *          application force the GC to run,the chances are the heap won't be full,and the result will be
         *          that garbage is collection inefficiently,and more often the application forces GC,the more
         *          efficient the GC becomes.
         *
         *          The Old Generation is used to store long surviving objects. Typically, a threshold is
         *          set for young generation object and when that age is met, the object gets moved to the
         *          old generation. Eventually the old generation needs to be collected. This event is called
         *          a major garbage collection.
         *
         *          The Permanent generation contains metadata required by the JVM to describe the classes
         *          and methods used in the application. The permanent generation is populated by the
         *          JVM at runtime based on classes in use by the application.P.S. Permanent generation is also called
         *          the method area,and it stores classes or interned character strings(String pool),so this area is definitely
         *          not for objects that survived from the old generation to stay permanently,A GC may
         *          occur in this area,and is still counted as a major GC.
         *
         *          An allocation simply claims some portion of a memory array and moves the offset pointer forward
         *          The next allocation starts at this offset and claims the next portion of the array.
         *          When an object is no longer used, the garbage collector reclaims the underlying memory and
         *          reuses it for future object allocation. This means there is no explicit deletion and no memory
         *          is given back to the operating system.
         *
         *          In order to understand GC,let's learn about the young generation,where the objects are created
         *          for the first time,the young generation is divided into 3 spaces:
         *              one Eden space
         *              two Survivor spaces
         *          -- the majority of newly created objects are located in the Eden space.
         *          -- after one GC in the Eden space,the surviving Objects are moved to one of the Survivor spaces
         *          -- After a GC in the Eden space,the objects are piled up into the Survivor space,where other
         *              surviving objects already exist.
         *          -- once a survivor space is full,surviving objects are moved to the other survivor space,then,the
         *              survivor space that is full will be changed to a state where there is no data at all.
         *          -- the objects that survived these steps that have been repeated a number of times are moved
         *              to the old generation.
         *           Bump-the-pointer technique tracks the last object allocated to the Eden space,that object will be
         *           located on top of the Eden space,And if there is an object created afterwards,it checks only if
         *           the size of the object is suitable for the Eden space,if the said object seems right,it will be placed
         *           in the Eden space and the new object goes on top,So when new Objects are created,only the lastly
         *           added object need to be checked,which allows much faster memory allocation,however it is different
         *           story if we consider a multithreaded environment,To save objects used by multiple threads in
         *           the Eden space the Thread-safe,an inevitable lock will occur and the performance will drop due
         *           to the lock-contention.Thread-Local-Allocation-Buffers(TLAB) is the solution to this problem is
         *           HotSpot VM,this allows each thread have a small portion of its Eden space that corresponds to its
         *           own share,As each thread can only access to their own TLAB.
         *
         *          The old generation basically performs a GC when the data is full,the Execution procedure varies by
         *          the GC type,so it would easier to understand if you know different types of GC.
         *
         *          there are 5 GC types:
         *              -- Serial GC
         *              -- Parallel GC
         *              -- Parallel Old GC(Parallel Compacting GC)
         *              -- Concurrent Mark & Sweep GC
         *              -- Garbage first GC
         *
         *          (Serial GC)Mark Sweep Compact GC algorithm:
         *              -- the first step of this algorithm is to mark the surviving objects in the old generation
         *              -- then,it checks the heap from the front and leaves only the surviving ones behind
         *              -- in the last step,it fills up the heap from the front with the objects so that the objects are
         *                  piled up consecutively,and divides the heap into two parts:one with objects and one without objects.
         *          the difference between the serial GC and parallel GC is that the serial GC uses only one thread
         *          to process a GC,the parallel GC uses several threads to process a GC,and therefore,faster.This GC is useful
         *          when there is enough memory and a large number of cores.
         *
         *          The Concurrent Mark-Sweep GC is much more complicated than any other GC types that I have explained so
         *          far,The surviving objects among the objects closest to the classloader are searched,so the pausing time
         *          is very short,in the concurrent mark step,the objects referenced by the surviving objects that have just
         *          been confirmed are tracked and checked.the difference of this step is that it proceeds while other
         *          threads are processed at the same time,in the remark step,the objects that were newly added ot stopped
         *          being referenced in the concurrent mark step are checked.is used when the response time from all
         *          applications is crucial.
         *
         *          The CMS collector is generational,thus both minor and major collections occur.the CMS collector attempts
         *          to reduce pause times dur to major collections by using separate garbage collector threads to trace the
         *          reachable objects concurrently with the execution of the application threads.During each major collection
         *          cycle,the CMS collector pauses all the application threads for a brief period at the beginning of the
         *          collection and again toward the middle of the collection.
         *
         *          if data exists in both survivor spaces,or the usage is 0 for both spaces,then take that as a
         *          sign that something is wrong with your system.
         *
         *
         *      Java safe-point:
         *          -- A thread can be at a safePoint or not be at a safePoint,then at a sagePoint,the thread's
         *             representation of it's Java machine state is well described,and can be safely manipulated
         *             and observed by other threads in the JVM,when not at a safePoint,the thread's representation
         *             of the Java machine state will not be manipulated by other threads in the JVM
         *          -- Being at a safe-point does not mean being blocked,but being blocked always happens at a safe-point.
         *          -- The JVM may choose to reach to a global safe-point(aka Stop-the-world),where all threads are at
         *             safe-point and can't leave the safe-point until the JVM decides to let it go,This is useful for
         *             doing all sorts work(GC) that require ALL threads to be at a well described state.
         *          -- Some JVMs can bring individual threads to safe-point without requiring a global safe-point. E.g.
         *             Zing uses the term Checkpoint (first published in [1]) to describe a JVM mechanism that individually
         *             passes threads through thread-specific safe-points to perform certain very short operations on
         *             individual thread state without requiring a Stop-The-World pause.
         *          -- All [practical] JVMs apply some highly efficient mechanism for frequently crossing safepoint opportunities,
         *             where the thread does not actually enter a safepoint unless someone else indicates the need to do
         *             so. E.g. most call sites and loop backedges in generated code will include some sort of
         *             safepoint polling sequence that amounts to "do I need to go to a safepoint now?". Many HotSpot
         *             variants (OpenJDK and Oracle JDK) currently use a simple global "go to safepoint" indicator in
         *             the form of a page that is protected when a safepoint is needed, and unprotected otherwise. The
         *             safepoint polling for this mechanism amounts to a load from a fixed address in that page. If the
         *             load traps with a SEGV, the thread knows it needs to go to enter a safepoint. Zing uses a different,
         *             per-thread go-to-safepoint indicator of similar efficiency.
         *
         *
         *
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
