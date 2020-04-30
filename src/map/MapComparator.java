package map;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * map中数据进行比较
 * Comparator<T> 比较器</>
 * Comparable<T></>排序比较
 */
public class MapComparator {
    public static void main(String[] args) {
        /**
         * hashmap
         */
        HashMap<String, Integer> map = new HashMap<>();
        map.put("lei", 15);
        map.put("ming", 1);
        map.put("mao", 5);
        map.put("min", 6);
        map.put("qi", 9);
        map.put("zheng", 23);
        map.put("ni", 78);
        map.put("mei", 90);
        map.put("de", 12);
        map.put("ta", 7);
        System.out.println(map.keySet());
        System.out.println(map.containsValue(90));
        System.out.println();

        Set<String> entrySet = map.keySet();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2) - (map.get(o1));
            }
        });

        //System.out.println(map.keySet());

        Iterator<String> iter = list.iterator();    //获取List集合的迭代器,String为迭代元素的类型
        while (iter.hasNext()) {
            String key = iter.next();
            Integer value = map.get(key);
            System.out.println("key:" + key + "-->value:" + value);
        }


        /**
         * treeMap
         */
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("lei", 15);
        treeMap.put("ming", 1);
        treeMap.put("mao", 5);
        treeMap.put("min", 6);
        treeMap.put("qi", 9);
        treeMap.put("zheng", 23);
        treeMap.put("ni", 78);
        treeMap.put("mei", 90);
        treeMap.put("de", 12);
        treeMap.put("ta", 7);
        System.out.println(treeMap.keySet());
        Set set = treeMap.keySet();

        ArrayList<String> list1 = new ArrayList<>(set);
        /**
         * list 集合存储的是 new Comparator<String> 泛型中的值
         */
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return treeMap.get(o2) - (treeMap.get(o1));
            }
        });

        //top 3
        Iterator<String> iterator = list1.subList(0, 3).iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = treeMap.get(key);
            System.out.println("key:" + key + "-->value:" + value);
        }

        String string = "stringkeuuuyiterallltornextjjstringkeyimtemnkgfdsratornext";
        char[] chars = string.toCharArray();
        HashMap<String, Integer> cmap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (cmap.containsKey(chars[i] + "")) {
                Integer temp = cmap.get(chars[i] + "") + 1;
                cmap.put(chars[i] + "", temp);
            } else {
                cmap.put(chars[i] + "", 1);
            }
        }


        List<String> stringList = new ArrayList<>(cmap.keySet());
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return cmap.get(o2) - cmap.get(o1);
            }
        });

        for (String str : stringList.subList(0,5)) {
            System.out.println("key:" + str + "-->value:" + cmap.get(str));
        }

    }


}