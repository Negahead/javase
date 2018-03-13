package languagetopic;

/**
 * Generics enable types(classes and interfaces)to be parameters when defining classes,interfaces and methods.
 * type parameters provide a way for you to re-use the same code with different inputs.the difference is that
 * the inputs to formal parameters are values,while the inputs to type parameters are type.
 *
 * generics give you great compile-time safety,but unless you use these
 * wildcards types,they don't give you the flexibility
 *
 * Java Generics were introduced in JDK 5.0 with the aim of reducing bugs and add an
 * extra layer of abstraction over types.
 *
 *
 * Producer extends,Consumer super
 * for a T producer,use Foo<? extends T>
 * for a T consumer,use Foo<? super T>
 * for a T consumer and producer,use Foo<T>
 * for neither T consumer and producer,use Foo<?>
 *
 * for any concrete type A,List<A> is a subtype of List<?>.
 *
 *
 * no wildcard type for return value:
 *      --wouldn't make the API any more flexible,
 *      --Would force the user to deal with wildcard types explicitly
 *      --User should not have to think about wildcards to use your API
 *
 *  whenever you call one of the generic methods,the compiler is doing what's
 *  called type inference,it is figuring out a type that works for E based on
 *  your argument,if it went wrong,you provide an explicit type parameter
 *
 *  Map.putIfAbsent() is slow.
 */


import java.util.*;

/**
 * Polymorphism in Java describes a language's ability to process objects of various types and classes
 * through a single,uniform interface.
 *
 * Polymorphism in Java has two types:Compile time polymorphism(static binding) and Runtime polymorphism
 * (dynamic binding),method overloading is an example of static polymorphism,while method overriding is
 * an example of dynamic polymorphism.Runtime polymorphism is a concept in which object is not aware
 * of binding during compile time,it will be decided at run time that which object is going to bind
 * with which method,
 *
 * Any objects that satisfies more than one IS-A relationship is polymorphism in nature.
 */
public class Generic {
    public static void main(String[] args) {
        /**
         * s.add(10); will raise capture not applied error,why?
         * List<? extends Number> means a list of some type,which is a subtype of Number,but we do not known
         * which type.As we do not know which subtype is the type parameter,we can't put Number objects in it,
         * neither Integer or Float.such a list can only be used for taking elements out of the list,not to
         * add elements at all(apart from null),if List is used as a consumer,it should be declared as ? super Number
         */
        List<? extends Number> s = new ArrayList<>();
        s.add(null);

        List<? super Number> s3 = new ArrayList<>();
        s3.add(100);
        s3.add(100.34);





        String[] strings = {"a","b","c"};
        generic(strings);
        Holder h = new Holder("name");
        h.set(1);
        foo("");
        foo(1);
        foo(100f);
        foo(100L);
        /**
         * for backward compatibility,assigning a parameterized type to a raw type is allowed.
         * but if you assign a raw type to a parameterized type,you get a warning.but warning
         * is not a compile time error,it is just warning.but List<Object> list = new ArrayList<String> is not allowed.
         */
        List list = new ArrayList<String>();
        /**
         * any invocation of add will be allowed if the argument is compatible with Number.
         */
        List<Number> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(10.34f);
        List<Number> integers = new ArrayList<>();
        integers.add(10);
        integers.add(1000);
        add(integers);
        Set<Integer> s1 = new HashSet<>();
        s1.add(100);
        s1.add(10);
        Set<Integer> s2 = new HashSet<>();
        s2.add(10);
        common(s1,s2);
        int[] ints = {0,1,2,3,4};
        int[] ints1 = Arrays.copyOf(ints, 10);
        for(int i : ints1) {
            System.out.println(i);
        }


        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class,"Java");
        favorites.putFavorite(Integer.class,0xcafebabe);
        favorites.putFavorite(Class.class,Favorites.class);
        System.out.println(favorites.getFavorite(String.class) + " " + favorites.getFavorite(Integer.class)
        + " " + favorites.getFavorite(Class.class).getName());
        System.out.println(Float.floatToIntBits(1.25f));
        System.out.println(Math.abs(Integer.MIN_VALUE));

        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start,end);
        System.out.println(period.start());
        start.setYear(120);
        System.out.println(period.start());
    }

    static void genericArray1() {
        List[] stringList = new List[2];
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        strings.add("name");
        integers.add(100);
        stringList[0] = strings;
        stringList[1] = integers;

    }

    static int common(Set<?> a,Set<?> b) {
        int result = 0;
        /**
         * except a.add(null),any a.add(element) is illegal.
         */
        for(Object o : a) {
            if(b.contains(o)) {
                result++;
            }
        }
        return result;
    }

    /**
     * you are not allowed to pass List<Integer> or List<Double>,because these are not subtypes of
     * List<Number> even though Integer is a subtype of Number.MyClass<A> has no relationship with
     * MyClass<B>,regardless of whether or not A and B are related,the common parent if MyClass<A>
     * and MyClass<B> is Object.you can subtype a generic class or interface by extending it or
     * implementing it.the relationships of one class or interface and the type parameters of another are
     * determined by the extends and implements clauses.
     *
     * <T extends Number> and <? extends Number>,the reason for declaring T is so that you can refer it again.
     * @param numbers
     */
    static void add(List<Number> numbers) {

    }

    /**
     * Type erasure applies to the use of generics,There's definitely metadata in the class file to say whether
     * or not a method/type is generic,and what the constrains are etc.But when generic are used,they are
     * converted into compile-time checks and execution-time casts.so THis code:
     *      List<String> list = new ArrayList<String>();
     *      list.add("Hi");
     *      String x = list.get(0)
     * is compiled into
     *      List list = new ArrayList();
     *      list.add("Hi");
     *      String x = (String) list.get(0);
     * At execution time,the type information is gone.
     */
    static void generic(Object[] param) {
//        param[0] = 1;
    }

    /**
     * Generic methods are those methods that are written with a single method declaration and can be called
     * with arguments of different types.the type parameter's scope is limited to the method where it is
     * declared
     *  -- Generic methods have type parameter(the diamond operator enclosing the type) before the return
     *      type of method declaration
     *  -- Type parameters can be bounded
     *  -- Generic methods can have different type parameters separated by commas in the method signature.
     * @param a
     * @param <E>
     */
    public static <E> void foo(E a) {
        System.out.println(a.getClass().getName());
    }

    static class Holder<T> {
        private T a;
        public Holder(T a) {
            this.a = a;
        }
        public void set(T a) {
            this.a = a;
        }
        public T get() {
            return this.a;
        }
    }

    /**
     *  A reifiable type is a type whose type information is fully available a runtime,This includes primitives,
     * non-generic types,raw types,and invocations of unbound wildcards.
     *
     * Non-reifiable types are types where information has been removed at compile-time by type erasure,
     * invocations of generic types that are not defined as unbounded wildcards.
     *
     * A type is reifiable if it is one of the following:
     *      -- A primitive type
     *      -- A non-parameterized class or interface type(Number,String,Runnable)
     *      -- A parameterized type in which all type arguments are unbounded wildcards(List<?>,ArrayList<?>,Map<?,?>
     *      -- A raw type
     *      -- An array whose component type is reifiable(int[],Number[],List<?>[],List[]
     *
     *
     * A type is not reifiable if it is one of the following:
     *      -- A type variable(such as T)
     *      -- A parameterized type with actual parameters(such as List<Number>)
     *      -- A parameterized type with a bound(List<? extends Number> or Comparable<? super String>
     *
     *
     * when you use generics,much of the time,the compile-time type information is lost.At run time,often all the
     * program knows about a reference is that is a reference to some sort of Object.If all the type information
     * is also known at run-time,the type is called reifiable.
     *
     * Type erasure ensures that no new classes are created for parameterized types,consequently,generics incur overhead
     *
     *
     * /


     /**
     *  Type erasure:
     *      Type erasure can be explained as the process of enforcing type constraints only at compile time and
     *      discarding the element type information at runtime,below example,when compiled,the unbound type E gets replaced
     *      with actual type of Object.the produced bytecode,therefore,contains only ordinary classes,interfaces and methods.
     *
     *      At the class level,type parameters on the class are discarded during code compilation and replaced with
     *      its first bound,or Objects if the type parameter is unbound.
     *
     *      for method-level type erasure,the method's type parameter is not stored but rather converted to its parent
     *      type Object if it;s unbound or it's first bound class when it is bound
     */

    static class MyStack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings(value = "ignore")
        public MyStack() {
            elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];

        }

        public void push(E e) {

        }

        public static <E> void constainsElement(E[] elements,E element) {

        }


    }



    /**
     *  Raw Types behaves just like they were before generics were introduced,using Objects like the following:
     *      List names = new ArrayList();
     *      names.add("John");
     *      names.add("Mary");
     *      names.add(Boolean.False); // not a compile time error.
     *
     *   Presumably,if you want names to contain only String,you could perhaps still use a raw type
     *   and manually check every add yourself,or you let the compiler do all the work for you,
     *   harnessing the power of Java Generics
     *
     *   What is the difference between the raw type List and the parameterized type List<Object>?
     *   loosely speaking,the former has opted out generic type checking ,while the latter explicitly
     *   told the compiler that it is capable if holding objects of any type,while you can pass a
     *   List<String> to a raw type List,you can't pass it to a parameter of type List<Object>,there are
     *   subtyping rules for generics,and List<String> is a subtype if the raw type List,but not of
     *   the parameterized type List<Object>,As a consequence,you lose type safety if you use raw type
     *   like List,bot not if you use a parameterized type like List<Object>.
     */
    static class MyType<E> {
        class Inner {}
        static class Nested {}

        public static void main(String[] args) {
            MyType mt; // warning,MyType is a raw type
            MyType.Inner inn; // warning MyType.Inner is a raw type.
        }
    }
    /**
     * why no generic array?
     *      Arrays of generic types are not allowed because they're not sound,the problem is due to the interaction
     *      of Java arrays,which are not statically sound but are dynamically checked,with generics,which are
     *      statically sound and not dynamically checked.Java arrays(unlike generics) contain,at runtime information
     *      about its component type,so you must know the component type then you create the array.
     *
     *      arrays are covariant and generics are invariant.
     *          covariant means that you can assign subclass type array to its superclass array reference:
     *              Object objectArray[] = new Integer[10];
     *          invariant means you cannot assign subclass type generic to its super class generic reference
     *          because in generics any two distinct types are neither a subtype nor a supertype.
     *              List<Object> objectLists = new ArrayList<Integer>(); // won't compile
     */
    static void genericArray() {
        /**
         *
         */
//        List<Integer> a[] = new List<Integer>[1];
    }
}


class Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<>();
    public <T> void putFavorite(Class<T> type,T instance) {
        if (type == null) {
            throw new NullPointerException("type is Null");
        }
        favorites.put(type,instance);
    }
    public <T> T getFavorite(Class<T> type) {
        /**
         * cast(): cast and then return the casted object.
         */
        return type.cast(favorites.get(type));
    }
}

final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start,Date end) {
        this.start = start;
        this.end = end;
        if(start.compareTo(end) > 0) {
            throw new IllegalArgumentException("start is bigger than end");
        }
    }

    public Date start() {
        return this.start;
    }
    public Date end() {
        /**
         * defensive copy.
         */
        return new Date(end.getTime());
    }
}


