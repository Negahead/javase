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
    // called collision in HashMap.in this case ,a liked list is formed at that bucket location and
    // a new entry is stored as next node.If multiple keys have the same hashCode,then during put()
    // operation collision had occurred,which means multiple Entry objects stored in a bucket location
    // each Entry keeps track of another Entry,forming a linked list data structure.

    // If we try to retrieve an object from this linked list,we need an extra check to search correct
    // value,this is done by equals() method.Since each node contains an entry,HashMap keeps comparing
    // entry's key object with the passed key using equals() method and when it returns true,Map returns
    // the corresponding value.searching in linked list is O(n) operation.
    public static void main(String[] args) {

    }
}
