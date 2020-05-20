package collections.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHahMapDemo {
    public static void main(String[] args) {
        /**
         * public LinkedHashMap() {
         *     // 调用HashMap的构造方法，其实就是初始化Entry[] table
         *     super();
         *     // 这里是指是否基于访问排序，默认为false
         *     accessOrder = false;
         *   }
         *   这里accessOrder设置为false，表示不是访问顺序而是插入顺序存储的，这也是默认值，
         *   表示LinkedHashMap中存储的顺序是按照调用put方法插入的顺序进行排序的
         *   该变量为true时access-order，即按访问顺序遍历，如果为false，则表示按插入顺序遍历。默认为false
         */
        /*Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }*/

        // 第三个参数用于指定accessOrder值
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        System.out.println("开始时顺序：");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get("name1");
        Set<Map.Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
