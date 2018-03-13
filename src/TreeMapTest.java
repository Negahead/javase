import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String,String> treeMap = new TreeMap<>();
        treeMap.put("string","moonee");
        treeMap.put("zed","faker");
        treeMap.put("ash","zookeeper");
        for(Map.Entry e : treeMap.entrySet()) {
            System.out.println(e.getKey() + "====" + e.getValue()); // ordered
        }
    }
}
