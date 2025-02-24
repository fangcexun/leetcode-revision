package hot100.linkedList;

import java.util.HashMap;
import java.util.Map;

public class TestBook {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("1", "2");

        System.out.println(map.get("1"));
    }
}
