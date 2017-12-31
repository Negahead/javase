import POJO.InvoiceDetail;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Created by AlphaGo on 12/9/2017.
 */
public class HashMapTest {
    // when we call put() method,hashcode() method of the key object is called so that hash
    // function of the map can find a bucket location to store value object,which is actually
    // an index of the internal array,known as the table.when we call get() method,again the key
    // object generate same hash code(it's mandatory for it to do so to retrieve the object and that's
    // why HashMap keys are immutable) and we end up at the same bucket location.

    // since the internal arrays of HashMap is of fixed size,and if you keep storing objects,at some
    // point of time hash function will return same bucket location for two different keys,this is
    // called collision in HashMap.in this case ,a liked list(java ue self-balancing binary search tree) is formed at that bucket location and
    // a new entry is stored as next node.If multiple keys have the same hashCode,then during put()
    // operation collision had occurred,which means multiple Entry objects stored in a bucket location
    // each Entry keeps track of another Entry,forming a linked list data structure.

    // If we try to retrieve an object from this linked list,we need an extra check to search correct
    // value,this is done by equals() method.Since each node contains an entry,HashMap keeps comparing
    // entry's key object with the passed key using equals() method and when it returns true,Map returns
    // the corresponding value.searching in linked list is O(n) operation.

    // Hashing retrieval is a two step process:
    //      1.Find the right bucket(use hashCode())
    //      2.Search the bucket for the right element(use equals())
    // if two objects are considered equal,their hashcode must also be equal.the default hashcode method in
    // class Object is converting the internal address of the object into an integer.


    // hashMap permits null key and null value,the class makes no guarantees as to the order of the map.
    // LinkedHashMap class is based o both hash table and linked list to enhance the functionality of hash map,it
    // maintains a doubly-linked list running through all its entries in addition to an underlying array of default size 16,
    // it preserves the insertion order.
    // treeMap is Red-Black tree based NavigableMap implementation,it is default sorted according to the natural ordering of its key.
    // HashTable is synchronized,in contract to HashMap.
    public static void main(String[] args) {


        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("name","dopa");
        hashMap.put("age","23");
        hashMap.put("city","NewYork");
        hashMap.put("birthday","2017-12-29");
        hashMap.put("null",null);
        Class clazz = hashMap.getClass();
        System.out.println("clazz is of type " + clazz.getTypeName());
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for(Type t : genericInterfaces) {
            if(t instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) t;
                System.out.println(pType.getTypeName() + " is ParameterizedType");
                for(Type actualTypeArguments : pType.getActualTypeArguments() ){
                    System.out.println(actualTypeArguments.getTypeName());
                }

            }
            if(t instanceof TypeVariable) {
                TypeVariable pType = (TypeVariable) t;
                System.out.println(pType.getTypeName() + " is TypeVariable");
            }
            if(t instanceof GenericArrayType) {
                GenericArrayType pType = (GenericArrayType) t;
                System.out.println(pType.getTypeName() + " is GenericArrayType");
            }
        }

        hashMap.compute("birthday",((BiFunction<? super String, ? super String, ? extends String>) (k, v)->{
            if(v == null) {
                return "";
            } else {
                return v.concat(" AD");
            }
        }).andThen(s->{
            if(s == null) {
                return "";
            }
            return s.concat(" and then this");
        }));
        System.out.println(hashMap.get("birthday"));
        System.out.println(hashMap.getOrDefault("noSuchKey","defaultValue"));
        printMap(hashMap);

        List<String> strList = new ArrayList<>();
        strList.add("David");
        strList.add("Gourley");
        strList.add("Brian");
        strList.add("Totty");
        strList.add("age");
        strList.forEach(s->{
            hashMap.merge(s,"AAAA",(oldValue,value)->{
                return oldValue.concat(value);
            });
        });

        printMap(hashMap);


        Map<String,Integer> linkHashMap = new LinkedHashMap<>();
        linkHashMap.put("a",1);
        linkHashMap.put("b",2);
        linkHashMap.put("c",3);
        linkHashMap.put("d",4);

        printMap(linkHashMap);

        System.out.println("tree map ===================");
        TreeMap<String,Integer> treeMap = new TreeMap<>((s1,s2)->{
            return -s1.compareTo(s2);
        });
        treeMap.put("a",1);
        treeMap.put("b",2);
        treeMap.put("c",3);
        treeMap.put("dd",4);
        treeMap.put("Absence",4);
        treeMap.put("Max",4);
        treeMap.put("fear",4);
        treeMap.put("tear",4);
        printMap(treeMap);
        /**
         * from the least to to most significant according the Comparator,not literal greater than.
         */
        System.out.println(treeMap.ceilingKey("fc"));
        System.out.println(treeMap.firstEntry().getKey());
        System.out.println(treeMap.headMap("c"));








    }

    private static <K,V> void printMap(Map<K,V> map) {
        BiConsumer<K,V> biConsumer = (k,v)->{
            System.out.println(String.format("%20s",k) + "--->" + String.format("%-50s",v));
        };
        map.forEach(biConsumer);
    }
}
