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


import org.jetbrains.annotations.Contract;

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
         * is not a compile time error,it is just warning.
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


