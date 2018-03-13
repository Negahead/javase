import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("name","will");
        map.put("age","22");
        map.put("from","china");
        for(Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + "===>" + entry.getValue()); // preserve the store order
        }
    }
}
