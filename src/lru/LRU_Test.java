package lru;

import java.util.*;

/**
 * Created by zzl
 */
class LRUCache {

    /**
     * 初始容量
     */
    private int capacity;

    /**
     * hashMap
     */
    private Map<Integer, Integer> cache;
    /**
     * 双向链表
     */

    LinkedList<Integer> list;

    /**
     * 初始化构造函数
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public void put(Integer key, Integer value) {
        cache.put(key, value);
        if (!list.contains(key)) {
            list.add(key);
        }
        afterPut(key, value);
    }

    /**
     * 获取元素
     *
     * @param key
     * @return
     */
    public int get(Integer key) {
        if (cache.containsKey(key)) {
            afterGet(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    /**
     * 使用元素
     *
     * @param key
     */
    public void afterGet(Integer key) {
        list.remove(key);
        list.addLast(key);
    }

    /**
     * 添加元素后，长度超过设置长度，清除最久未使用的元素
     *
     * @param key
     * @param value
     */
    public void afterPut(Integer key, Integer value) {
        if (cache.size() > capacity) {
            Integer oldKey = list.getFirst();
            list.removeFirst();
            // System.out.println("old "+oldKey);
            cache.remove(oldKey);
        }
    }
}

public class LRU_Test {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());//容量
        LRUCache lru = new LRUCache(n);
        while (scanner.hasNextLine()) {
            String[] str = scanner.nextLine().split(" ");
            String op = str[0];
            if (op.equals("p")) {//put
                int key = Integer.valueOf(str[1]);
                int value = Integer.valueOf(str[2]);
                lru.put(key, value);
            } else {
                int key = Integer.valueOf(str[1]);
                int value = lru.get(key);
                System.out.println(value);
            }
        }
    }

}


/**
 * p 1 1 //put 1 1
 * p 2 2 //put 1 1
 * g 1 // 输出1
 * p 2 102 //将2对应的内容更新为102
 * p 3 3 //将3放到缓存中，此时缓存区满，需将最近最久未使用的调出来 置换掉
 * g 2 // 2是最近最久未使用，因此此时应该不存在2 输出 -1
 */
