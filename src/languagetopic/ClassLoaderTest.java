package languagetopic;


import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Java is dynamically linked system.This means all code is linked into the executing JVM at run time.instead of at
 * compile time.The means by which the dynamic linking takes place is through Java's ClassLoader system.
 *
 */

/**
 * The class loader will try to load the class using the path element that is found first.
 *
 * A class represents the code to be executed,whereas data represents the state associated with that code.State can
 * change,code generally does not.When we associate a particular state to a class,we have an instance of that class.
 * So different instances of the same class can have different state.but all refer to the same code.in Java,a class
 * will usually have its code contained in a .class file.(or network),whenever we compile any Java file,the compiler will
 * embed a public,static,final field named class,of the type java.lang.Class in the emitted byte code.
 *
 * In a JVM,each and every class is loaded by some instance of a java.lang.ClassLoader.The ClassLoader class is located
 * in the java.lang package and developers are free to subclass it to add their own functionality to class loading.
 *
 * ClassLoader loads that .class file into memory
 *
 * The class loader concept,one of the cornerstones of the Java virtual machine,describes the behavior of converting
 * a named class into the bits responsible for implementing that class.Because class loaders exist,the Java run time
 * does not need to know anything about files and file systems when running Java programs.
 *
 * All Java virtual machine include one class loader that is embedded in the virtual machine.This embedded loader is
 * called the primordial class loader.It is special because the virtual machine assumes that it has access to a
 * repository of trusted classes which can be run by the VM without verification.Its code implements both class path
 * searching and looking into zip files for classes.
 *
 * So when are classes loaded? there are exactly two cases: when the new bytecode is executed (Foo foo = new Foo());and
 * when the byte-codes make a static reference to a class.
 *
 * There are three types of built-in ClassLoader in Java:
 *      -- Bootstrap Class Loader - it loads JDK internal classes in $JAVA_HOME/lib,typically loads rt.jar and other core classes
 *      -- Extension Class Loader - it loads classes from JDK extensions directory,$JAVA_HOME/lib/ext
 *      -- System Class Loader - it loads classes from the current classpath that can be set while invoking a program
 *                              using -cp or -classpath command line options
 *
 *  Java ClassLoader are hierarchical and whenever a request in raised to load a class.it delegates it to its parent
 *  and in this way uniqueness is maintained in the runtime environment,if the parent class loader doesn't find the
 *  class then the class loader itself tries to load the class.
 *
 *  When JVM requests for a class,it invokes loadClass function of the ClassLoader by passing the fully classified name of the Class.
 *  loadClass function calls for findLoadedClass() method to check that the class has been already loaded or not.It's required
 *  to avoid loading the class multiple times.
 *
 *  whenever you have an application loading arbitrary classes into the system through your class loader,your application's
 *  integrity is at risk.Therefore,one of the jobs of any class loader is to protect the system name space.
 *
 *  The parent class loader for any class loader is the class loader instance that loaded that class loader.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        /**
         * when we are trying to load HashMap,our System ClassLoader delegates it to the extension ClassLoader,which in
         * turns delegates it to BootStrap ClassLoader that found the class and load it in JVM
         *
         * Classes loaded by a child class loader have visibility into classes loaded by its parent class loaders,So classes
         * loaded by System ClassLoader have visibility into classes loaded by Extensions and Bootstrap ClassLoader.
         */
        System.out.println("classloader for HashMap " + HashMap.class.getClassLoader()); // null,bootstrap classloader
        // System ClassLoader,sun.misc.Launcher$AppClassLoader@18b4aac2,it is responsible for loading all of the classes
        // kept in the path corresponding to the java.class.path system property
        System.out.println("classloader for this class " + ClassLoaderTest.class.getClassLoader());

        File file = new File("/home/me/Hello.java");
        System.out.println(file.exists());
        MyClassLoader classLoader = new MyClassLoader();
        // the user defined ClassLoader is loaded by the AppClassLoader(System ClassLoader)
        System.out.println(classLoader.getClass().getClassLoader());
        try {
            Class<?> string = classLoader.loadClass("String");
            Object o1 = string.newInstance();
            Method greetingMethod = string.getDeclaredMethod("greeting");
            greetingMethod.invoke(o1);
            Class<?> hello = classLoader.loadClass("Hello"); // load the class,will not trigger the static block.
            //Java compiler has no idea of the type you're creating when you call newInstance.so you only
            // get an Object back instead of a Hello object.
            // but Class<String> cls = Class.forName("java.lang.String");
            // String str = cls.newInstance();
            // this is the ability to create code that can be loaded at run time and executed.
            Object o = hello.newInstance();
//            Method greeting = hello.getDeclaredMethod("greeting", String.class);
//            greeting.setAccessible(true);
//            greeting.invoke(o,"Dopa");

            /**
             * reflection is the ability to examine the type of an object at run time.Reflection allows us to do away
             * with compiler-time type requirements,and class any arbitrary method at any arbitrary time on any
             * arbitrary object without having to know that object's type at compile time.
             */

            /**
             *             ((home.me.Hello)o).greeting("dopa");
             *  this will cause ClassCastException,the issue is that when you use your own classloader,you can not cast
             *  an object that was created from a loaded class into its original class.because only the custom class loader
             *  "knows" about the new class it has just loaded.there are two reasons for this,First,the classes in the JVM
             *  machine are considered castable if they have at least one common class pointer.However,classes loaded by
             *  two different class loaders will have two different class pointers and no classes in common(except Object),
             *  second,the idea behind having a custom class loader is to load classes after the application is deployed so
             *  the application does not know a priory about the classes it will load.To solve this,either the loaded class
             *  must be a subclass of a class that the application has loaded from its trusted repository,or the loaded class
             *  must implement an interface that was loaded form the trusted repository.
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class MyClassLoader extends ClassLoader {

    // set the parent ClassLoader,this is critical,your parent ClassLoader
    // should be the one that loaded you.regardless of which ClassLoader it actually is.
    public MyClassLoader() {
        super(MyClassLoader.class.getClassLoader());
    }
    private Class getClass(String name) throws ClassNotFoundException {
        String file  = name.replace(".", File.separator) + ".class";
        byte[] b = null;
        try {
            b = loadClassFileData(file);
            /**
             * Java .class file format isn't a format for how the bytes must lay out while residing on disk;this format only
             * describes how the bytecode making up a given compile Java class must exist when handed to the ClassLoader
             * defineClass method.
             */
            // we still use the inherited defineClass() method.
            Class c = defineClass(name,b,0,b.length); // before the Class can be used it must be resolved
            System.out.println("after defining class");
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] loadClassFileData(String name) throws IOException {
        System.out.println("the current class's class loader is " + getClass().getClassLoader());
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("loading class " + name);
        if(name.startsWith("java.")) {
            return super.loadClass(name); // user defined ClassLoader can't load core java class.or SecurityException
        }
        return getClass(name);
    }


}
