import java.io.Serializable;
import java.lang.reflect.*;
import java.util.*;

public class  SerializationTest<K,V,T> extends MapTest implements Serializable,Cloneable,InterfaceA,Comparator<Integer> {

    Map<? extends String,? extends Number> map = new HashMap<>();


    private List list = new ArrayList();


    public static void main(String[] args){

        SerializationTest obj = new SerializationTest();

        Class clazz = SerializationTest.class;


        // all the implemented interfaces
        AnnotatedType[] annotatedTypes = clazz.getAnnotatedInterfaces();
        // the superClass
        AnnotatedType superClass = clazz.getAnnotatedSuperclass();
        // MapTest
        System.out.println("getAnnotatedSuperclass() is "+superClass.getType().getTypeName());
        for(AnnotatedType a : annotatedTypes) {
            System.out.println("getAnnotatedInterfaces() is " + a.getType().getTypeName());
        }


        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for(Type t : genericInterfaces) {
            System.out.println("by getGenericInterfaces() method "+t.getTypeName());
        }
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println("by getGenericSuperclass() method " + genericSuperclass.getTypeName());

        System.out.println("SerializationTest modifier is " + clazz.getModifiers());


        /**
         * HashMap<K,V>,return K , V
         */
        TypeVariable[] typeParameters = obj.map.getClass().getTypeParameters();
        for(TypeVariable t : typeParameters) {
            System.out.println(t.getName());
        }

        /**
         * user defined K,V,T
         */
        TypeVariable[] typeParameters1 = clazz.getTypeParameters();
        for(TypeVariable t : typeParameters1) {
            System.out.println(t.getName());
        }

        try {
            /**
             * those field must be public ,either declared in this class or from the extended class or implemented interface,
             *
             *
             * but getDeclaredField() will return all the fields directly declared by the class,either public or private
             */
            Field[] presentField = clazz.getFields();
            for(Field f : presentField) {
                System.out.println("getFields() return " + f.getName());
            }

            for(Field f : clazz.getDeclaredFields()) {
                System.out.println("getDeclaredFields() return " + f.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(clazz.getField("name").get(new MapTest()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field mapField = clazz.getDeclaredField("map");
            AnnotatedType annotatedType = mapField.getAnnotatedType();
            /**
             * java.util.Map<java.lang.String, ? extends java.lang.Number>
             */
            System.out.println(annotatedType.getType().getTypeName());
            /**
             * SerializationTest
             */
            System.out.println("declaring class is " + mapField.getDeclaringClass().getTypeName());
            /**
             *  map field is Map<String,? extends Number> map = new HashMap<>();
             */
            ParameterizedType parameterizedType = (ParameterizedType)mapField.getGenericType();
            /**
             * raw type is java.util.Map
             */
            System.out.println("raw type is " + parameterizedType.getRawType().getTypeName());

            for(Type t : parameterizedType.getActualTypeArguments()) {
                /**
                 * java.lang.String
                 * ? extends java.lang.Number
                 */
                System.out.println("getActualTypeArguments() returns " + t.getTypeName());
            }

//            WildcardType wildcardType = (WildcardType) mapField.getGenericType();
//            for(Type t : wildcardType.getLowerBounds()) {
//                System.out.println(t.getTypeName());
//            }


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
