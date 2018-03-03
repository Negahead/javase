import java.util.ArrayList;
import java.util.List;

public class JVM {
    /**
     * The Java Virtual Machine is the cornerstone of the Java platform,it is the component of the technology
     * responsible for its hardware- and operating system-independence,the small size of its compiled code,and
     * its ability to protect users from malicious programs
     *
     * The JVM is an abstract computing machine,like a real computing machine,is has an instruction set and
     * manipulates various memory areas at run time.
     *
     * the Java Virtual machine knows nothing of the Java programming language,only of a particular binary
     * format: the class file format,a class file contains JVM instructions(or byte-codes) and a symbol table.
     *
     * Compiled code to be executed by the Java Virtual Machine is represented using a hardware- and operating
     * system-independent binary format,typically stored in a file known as the class file format.the class
     * file format precisely defines the representation of a class or interface including details such
     * as byte ordering that might be taken for granted in a platform-specific object file format.
     *
     * there are three kinds of reference types: class types,array types and interface types,there values are
     * reference to dynamically created class instances,arrays or class instances or arrays that implement
     * interfaces respectively.
     *
     * The JVM operates on two kinds of types:primitive types and reference types.there are ,correspondingly
     * two kinds of values that can be stored in variables,passed as arguments,returned by methods,and
     * operated upon:primitive values and reference values,the JVM expects that
     * nearly all type checking in done prior to run time,typically by a compiler,and does not have to
     * be done by the JVM itself.An object is either a dynamically allocated class instance or an array,
     * a reference to an object is considered to have JVM type:reference,values of type reference can be
     * thought of as pointers to objects.more than one reference to an object may exist.Objects are always
     * operated on,passed,and tested via values of type reference.
     *
     * the primitive data types supported by JVM are numeric types,boolean type,and the returnAddress type.
     * the value of the returnAddress type are pointers to the opcodes of JVM,of the primitive types,only the
     * returnAddress type is not directly associated with a Java programming language type.
     *
     * ReturnAddress type:
     *      the returnAddress type is used by JVM,the value of returnAddress type are pointers to the opcodes
     *      of JVM instructions,unlike the numeric primitive types,the returnAddress type does not correspond to
     *      any Java programming language type and cannot be modified by the running program.
     *
     * Run-Time Data Areas:
     *
     * The JVM defines various run-time date areas that are used during execution of a program.some of these
     * data areas are created on JVM start-up and are destroyed only when JVM exit,other data areas are per thread
     * ,per-thread data areas are created when a thread is created and destroyed when the thread exits.
     *      the PC register:
     *          the JVM can support many threads of execution at once,=each JVM thread has its own pc=(
     *          program counter) register,at any point,each JVM thread is executing the code a single method,
     *          namely the current method for that thread,if that method is not native,the pc register contains
     *          the address of the JVM instructions currently being executed,if the method currently being
     *          executed by the thread is native,the value of the JVM pc register is undefined.
     *      Java Virtual Machine Stacks:
     *          each JVM thread has a private JVM stack,=created at the same time as the thread=,JVM stack holds
     *          local variables and partial results,and plays a part in method invocation and return.A JVM
     *          stack stores frames(a set of frames),the memory of a JVM stack does no need to be contiguous.JVM stacks either
     *          to be of a fixed size or to dynamically expand and contract as required by the computation,
     *          if the computation in a thread requires a larger JVM stack than is permitted,JVM throws a
     *          StackOverFlowError,if insufficient memory can be made available to create the initial JVM
     *          stack for a new thread,the JVM throws an OutOfMemoryError.
     *      Heap:
     *          ==JVM has a heap that is shared among all JVM threads==,The heap is the runtime data area from which
     *          memory for all class instances and arrays is allocated.
     *          the heap is created on virtual machine start-up,heap storage for objects is reclaimed
     *          by a automatic storage management(known as a garbage collector),Objects are never explicitly
     *          de-allocated,if a computation requires more heap than can be made available by automatic
     *          storage management system,the JVM throws an OutOfMemoryError.
     *      Method Area:
     *          ==method area is shared among all JVM machine threads==,it stores ==per-class structures== such as
     *          the run-time constant pool,field and method data,and the code for methods and constructors,
     *          including the special methods used in class and instance initialization and interface
     *          initialization.Although the ==method area is logically part of the heap==,simple implementation
     *          may choose not to garbage collect or compact it.
     *          ps:
     *              each instance of the JVM has one method area and one heap,these areas are shared by all threads
     *              running inside the JVM,when the JVM loads a class file,it parses information about a type
     *              from the binary data contained in the class file,it places this type information into the method
     *              area
     *      Run-time constant pool:
     *          A run-time constant pool is a ==per-class or per-interface run-time representation== of the
     *          constant_pool table in a class file.It contains several kinds of constants,ranging from
     *          numeric literals at compile-time to method and field references that must be resolved at
     *          run-time,the run-time constant pool servers a function similar to that of a symbol table for
     *          a conventional programming language.===Each run-time constant pool is allocated from the JVM
     *          method area===,the run-time constant pool for a class or interface is constructed when the class
     *          or interface is created by the JVM.
     *          ps:
     *              A class file keeps all its symbolic references in one place,the constant pool,each class file
     *              has a constant pool,and each class or interface loaded by the JVM has an internal version of its
     *              constant pool called the runtime constant pool,the runtime constant pool is an implementation
     *              specific data structure that maps to the constant pool in the class file,thus after a type is
     *              initially loaded,all the symbolic references from the type reside in the type's runtime
     *              constant pool.
     *      Native Method stacks:
     *          An implementation of the JVM may use conventional stacks,colloquially called "C stacks",to
     *          support native methods.Native method stacks are typically ==allocated per thread ==when each
     *          thread is created.
     * Frames:
     *      A frame is used to store data and partial results,as well as to perform dynamic linking,return
     *      values for methods and dispatch exceptions.
     *      =A new frame is created each time a method is invoked=,A frame is destroyed when its method
     *      invocation completes,whether that completion is normal or abrupt.Frames are allocated from the
     *      JVM stack of the thread creating the frame,each frame has its own array of local variables(see below),its
     *      own operand stack and a reference to the run-time constant pool of the class of the current
     *      method.Only one frame,the frame for the executing methods,is active at any point in a given
     *      thread of control,this frame is referred as the current frame.and its method is known as the
     *      current method,the class in which the current method is defined is the current class,A frame
     *      ceases to be current if its method invokes another method or if its method completes,when a
     *      method is invoked,a new frame is created and becomes current when control transfers to a new
     *      method,on method return,the current frame passes back the result of its method invocation,if
     *      any,to the previous frame.the current frames is then  discarded as the previous frame becomes
     *      the current one.A frame created by a thread is local to that thread and cannot be references
     *      by any other thread.
     * Local variables:
     *      Each frame contains an array of variables known as its local variables,the length of the local
     *      variable array of a frame is determined at compile-time,Local variables are addressed by indexing,
     *      the index of the first local variable is zero,An integer is considered to be an index into the
     *      local variable array if and only if that integer is between zero and one less than the size of the
     *      local variable array.The JVM uses local variables to pass parameters on method invocation,on
     *      instance method invocation,local variable 0 is always used to pass a reference to the object on
     *      which the instance method is being invoked(this in the Java programming language),any parameters
     *      are subsequently passed in consecutive variables starting from local variable 1.
     * Dynamic Linking:
     *      Each frame contains a reference to the run-time constant pool for the type of the current method
     *      to support dynamic linking of the method code,the class file code for a method refers to a
     *      methods to be invoked and variables to be accessed via symbolic references,dynamic linking
     *      translates these symbolic method references into concrete method references,loading classes as
     *      necessary to resolve as-yet-undefined symbols,this late binding of the methods and variables
     *      make changes in other classes that a method uses less likely to break this code.
     * Synchronization:
     *      method level synchronization is performed implicitly,A synchronized method is distinguished in the
     *      run-time constant pool's method_info structure by the ACC_SYNCHRONIZED flag,the invoking a method
     *      with this flag,the executing thread enters a monitor,invokes the method itself and exit the monitor
     *      ,no other thread may enter it.
     *
     * Exception:
     *      each method in the JVM may be associated with zero or more exception handlers.An exception handler specifies
     *      the range of offsets into the JVM code implementing the method for which the execution handler is active,
     *      describes the type of exception that the exception handler is able to handle,and specifies the location of
     *      the code that is to handle that exception,An exception matches exception handler if the offset of the
     *      instruction that causes the exception is in the range of offsets of the exception handler and the exception
     *      type is the same class as or a subclass of the class of exception that the exception handler handles,when
     *      an exception is thrown,the JVM searches for a matching exception handler in the current method,If a matching
     *      exception handler is found,the system branches to the exception handling code specified by the matched handler,
     *      if no such handler is found in the current method.the current method invocation completes abruptly,on abrupt
     *      completion,the operand stack and local variables of the current method invocation are discarded,and its frame
     *      is popped,reinstating the frame of the invoking method,the exception is the rethrown in the context of the
     *      invoking frame and so on,continuing up the method invocation chain,if no suitable exception handler is
     *      found before the top of the method invocation chain is reached,the exception of the thread in which the
     *      exception was thrown is terminated.
     *
     *  The ClassFile Structure:
     *      ClassFile {
     *          u4          magic;
     *          u2          minor_version;
     *          u2          major_version;
     *          u2          constant_pool_count;
     *          cp_info     constant_pool[constant_pool_count-1];
     *          u2          access_flags;
     *          u2          this_class;
     *          u2          super_class;
     *          u2          interface_count;
     *          u2          interfaces[interface_count];
     *          u2          fields_count;
     *          field_info  fields[fields_count];
     *          u2          methods_count;
     *          method_info methods[methods_count];
     *          u2          attributes_count;
     *          attribute_info attributes[attributes_count];
     *      }
     *
     *   Understanding how one compiler utilizes the JVM is useful to the prospective compiler writer,as well as to one
     *   trying the understand the JVM itself.the term compiler is sometime used when referring to a translator from
     *   the instruction set of a JVM to the instruction set of a specified CPU.one example of such a translator is
     *   a just-in-time(JIT) code generator,which generates platform-specific instruction only after JVM code has
     *   been loaded.Many numeric constants,as well as objects,fields,and method,are accessed via the run-time
     *   constant pool of the current class.
     *
     *   the normal method invocation for a instance method dispatches on the run-time type of the object,such an
     *   invocation is implemented using the invoke-virtual instruction,which takes as its argument an index
     *   to run-time constant pool entry gining the internal form of the binary name of the class type of the
     *   object.
     *
     *   JVM class instances are created using the JVM new instructions,at the level of the JVM,a constructor appears
     *   as a method with the compiler-supplied name <init>,this specially named method is known as the instance
     *   initialization method,multiple instance initialization methods,corresponding multiple constructors,may exist
     *   for a given class.once the class instance(Class MyObj) has been created and its instance variables,including those of the
     *   class and all of its superclasses,have been initialized to their default values,an instance initialization
     *   method if the new class instance is invoked.
     *
     *
     *   the JVM loads,links and initializes classes and interfaces,loading is the process of finding the binary
     *   representation of a class or interface type with a particular name and creating a class or interface from
     *   that binary representation.Linking is the process of taking a class or interface and combining it into
     *   the run-time state of the JVM so that it can be executed.initialization of a class or interface consists
     *   of executing the class or interface initialization method <clinit>
     *
     *   Class and interface names that appear in class file structure are always represented in a fully qualified
     *   form known as binary names.
     *
     *   The JVM maintains a per-type constant pool,a run-time data structure that servers many of the purpose of the
     *   symbol table of a conventional programming language implementation.
     *
     *   the Java programming language requires that identical string literals must refer to the same instance
     *   of class String,
     *
     *   the JVM starts up by creating an initial class,which is specified in an implementation-dependent manner,
     *   using the bootstrap class loader,the JVM then links the initial class,initializes it,and invoke the public
     *   class method void main(String[]),the invocation of this method drives all further execution,execution of
     *   JVM instructions constituting the main method may cause linking of additional classes and interfaces,as well
     *   as invocation of additional methods
     *
     *   Creation of a class or interface C denoted by the name N consists of the construction in the method area of
     *   JVM of an implementation-specific internal representation of C.Class or interface creation is triggered by
     *   another class or interface D,which references C through its run-time constant pool,Class or interface creation
     *   may also triggered by D invoking methods in certain Java SE platform class libraries such as reflection.
     *
     *   If C is not an array class,it is created by loading a binary representation of C using a class loader,Array
     *   classes do not have an external binary representation,they are created by the JVM rather by a class loader.
     *
     *   There are two kinds of class loaders: the bootstrap loader supplied by the JVM and user-defined class loader.
     *   Every user-defined class loader is an instance of a subclass of the abstract class ClassLoader.Application
     *   employ user-defined class loaders in order to extend the manner in which the JVM dynamically loads and thereby
     *   creates classes.User-defined class loaders can be used to create classes that originate from user-defined
     *   sources,For example,a class could be downloads across a network,generated on the fly,oe extracted from
     *   an encrypted file.
     *
     *   A class loader L may create C by defining it directly or by delegating to another class loader,if L creates C
     *   directly,we say that L defines C or,equivalently that L is the defining loader of C.
     *
     *   At run time,a class or interface is determined not by its name alone,but by a pair: its binary name and its
     *   defining class loader.Each such class or interface belongs to a single run-time package,the run time package of
     *   a class or interface is determined by the package name and defining class loader of the class or interface.
     *
     *   The JVM uses one of the three procedures to create class or interface C denoted by N:
     *      if N denotes a non-array class or an interface,one of the two following methods is used to load and thereby create C:
     *          -- if D was defined by the bootstrap class loader,then the bootstrap class loader initiates loading of C
     *          -- if D was defined by a user-defined class loader,then that same user-defined class loader initiates loadering
     *              of C
     *      otherwise N denotes an array class,An array class is create directly by the JVM,not by a class loader,However,
     *      the defining class loader of D is used in the process of creating array class C.
     *
     *
     *   The following steps are used to load and thereby create the non-array class or interface C denotes by N using
     *   the bootstrap class loader.
     *      first,the JVM determines whether the bootstrap class loader has already been recorded as an initiating class
     *      loader of class or interface denoted by N,if so,the class or interface is C,and no class creation is necessary.
     *
     *      otherwise,the JVM machine passes the argument N to an invocation of a method on the bootstrap class loader to
     *      search for purported representation of C in a platform-dependent manner,typically,a class or interface will
     *      be represented using a file in a hierarchical file system,and the name of the class or interface will be
     *      encoded in the pathname of the file.if no purported representation of C is found,loading throws an instance
     *      if ClassNotFoundException.
     *
     *      Then the JVM attempts to derive a class denoted by N using the bootstrap class loader from the purported
     *      representation using the algorithm,That class is C.
     *
     *      P.S.:
     *          A class represents the code to be executed,whereas data represents the state associated with that code.
     *          state can change,code generally does not,when we associate a particular state to a class,we have an
     *          instance of that class.so different instances of the same class can have different state,but all
     *          refer to the same code,in Java,a class will usually have its code contained in a class file,in the Java
     *          run time,each and every class will have ots code also available in the form of a first-class Java object,
     *          which is an instance of java.lang.Class,whenever we compile any Java file,the compiler will embed a
     *          public,static,final file named class of the type java.lang.Class,in the emitted byte code. Since this
     *          field is public ,we can access it using dotted nation like :
     *                  java.lang.Class clazz = MyClass.class.
     *          once a class is loaded into a JVM,the same class will not be loader again,This leads to a question of what
     *          is meant by "the same class",similar to the condition that an object has a specific state,an identity,
     *          and that an object is always associated with its code(class),a class loaded into a JVM also has a specific
     *          identity.
     *
     *          In Java,a class is identified by its fully qualified class name,the fully qualified class name consists of
     *          the package name and the class name,But a class is uniquely identified in a JVM using its fully qualified
     *          class name along with the instance of the ClassLoader that loaded the class.Thus,if a class named Cl in the
     *          package Pg is loader by an instance kl1 of the class loader KlassLoader,the class instance C1,i.e.
     *          C1.class is keyed in the JVM as(Cl[class name],Pk[package name],Kl1[class loader name]),This means that the two
     *          class loader instance(Cl,Pg,kl1) and (Cl,Pg,kl2) are not one and the same,and classes loader by them are
     *          completely different and not type-compatible to each other.
     *
     *          in JVM.each and every class is loaded by some instance of a java.lang.ClassLoader,whenever a new JVM is started
     *          by typing java MyMainClass,the bootstrap class loader is responsible for loading key Java Classes like
     *          java.lang.Object and other runtime code into memory first,the runtime classes are packaged inside of
     *          the JRE/lib/rt.jar file,bootstrap class loader is a native implementation.
     *
     *          ALl class loaders except the bootstrap class loader have a parent class loader,moreover,all class loader are of
     *          type java.lang.ClassLoader,the above two statements are different,The most important aspect is to correctly
     *          set the parent class loader,the parent class loader for any class loader is the class loader instance
     *          that loaded that class loader(a class loader itself is a class).
     *
     *
     *  Linking:
     *      Linking a class or interface involves verifying and preparing that class or interface.its direct superclass,
     *      its direct superinterface,and its element type(if it is an array type)
     *
     *      preparation:
     *          preparation involves creating the static filed for a class or interface an initializing such fields to
     *          their default values.this does not require the execution of any JVM code.
     *
     *      resolution:
     *          resolution  is the process if dynamically determining concrete values from symbolic references in the
     *          run time constant pool.
     *
     *
     * JVM object memory structure:
     *      class MyClass {
     *          byte a;
     *          int c;
     *          boolean d;
     *          long e;
     *          Object f;
     *      }
     *
     *  Every object is aligned to an 8 bytes granularity:
     *
     *  [HEADER:    8 bytes] 8
     *  [a:         1 byte ] 9
     *  [padding:   3 bytes] 12
     *  [c:         4 bytes] 16
     *  [d:         1 byte ] 17
     *  [padding:   7 bytes] 24
     *  [e:         8 bytes] 32
     *  [f:         4 bytes] 36
     *  [padding:   4 bytes] 40
     *
     *  14 bytes are wasted with padding and the object would be 40 bytes of memory. By reordering the objects using
     *  some rules,the in memory structure of the objects becomes:
     *
     *  [HEADER:    8 bytes] 8
     *  [e:         8 bytes] 16
     *  [c:         4 bytes] 20
     *  [a:         1 byte ] 21
     *  [d:         1 byte ] 22
     *  [padding    2 bytes] 24
     *  [f:         4 bytes] 28
     *  [padding    4 bytes] 32
     *
     *  only 6 bytes are used for padding.
     *
     *  class attributes are ordered like this: first longs and doubles,the ints and floats;then chars and shorts;
     *  then bytes and booleans,and last the references. the attributes aligned to their own granularity.
     *
     *  Fields that belong to different classes of the hierarchy are never mixed up together.Fields of the superclass
     *  come first,followed by the fields of the subclass.
     *
     *  between the last field of the super class and the first field of the subclass there must be padding to
     *  align to a 4 bytes boundary.
     *
     *  Memory leak in Java is a situation where some objects are not used by the application any more,but GC
     *  fails to recognize them as unused.as a result,these objects remains in memory indefinitely,reducing the
     *  amount of memory available to the application.
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) {
        /**
         * interned strings are stored in main heap(young and old generation) from Java 7 onwards(used to be saved in Permanent Generation)
         * the inter() method helps in comparing two String objects with == operator by looking into the pre-existing pool
         * of string literals,and it is faster than equals() method.
         *
         * Java automatically interns all Strings by default,remember that we only need to intern strings when they are not
         * constants,and we want to be able to quickly compare them to other interned strings, the inter() method should be
         * used on strings constructed with new String() in order to compare them by == operator.
         */
//        String str1 = "java";
//        String str2 =  "java";
//        System.out.println(str1 == str2); // true,interned
//        System.out.println(str1.intern() == str1); // true
//        System.out.println(str1.intern() == str2); // true

        String str1 = new String("java");
        String str2 = new String("java");
        System.out.println(str1 == str2); // false
        String str = new StringBuilder("ja").append("va").toString();
        System.out.println(str.intern() == str); // false
        System.out.println(str.intern() == str); // false
    }
}
