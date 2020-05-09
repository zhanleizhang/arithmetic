package lru;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        LruLinkedMap<String, String> ss = new LruLinkedMap(5, 0.75f, true);

        ss.put("1", "3");
        ss.put("2", "4");
        ss.put("3", "6");
        ss.put("4", "1");
        ss.put("5", "5");
        ss.put("6", "6");
        ss.put("9", "1");
        ss.put("8", "5");

        for(Map.Entry e: ss.entrySet()) {
            System.out.println(e.getKey());
        }
        System.out.println("---------------");

        ss.get("1");

        for(Map.Entry e: ss.entrySet()) {
            System.out.println(e.getKey());
        }
        System.out.println("---------------");
        ss.put("7", "10");

        for(Map.Entry e: ss.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}