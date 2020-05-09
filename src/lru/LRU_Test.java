package lru;

import java.util.*;

/**
 * Created by zzl
 */
class LRUCache {

    /**
     * ��ʼ����
     */
    private int capacity;

    /**
     * hashMap
     */
    private Map<Integer, Integer> cache;
    /**
     * ˫������
     */

    LinkedList<Integer> list;

    /**
     * ��ʼ�����캯��
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }

    /**
     * ���Ԫ��
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
     * ��ȡԪ��
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
     * ʹ��Ԫ��
     *
     * @param key
     */
    public void afterGet(Integer key) {
        list.remove(key);
        list.addLast(key);
    }

    /**
     * ���Ԫ�غ󣬳��ȳ������ó��ȣ�������δʹ�õ�Ԫ��
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
        int n = Integer.valueOf(scanner.nextLine());//����
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
 * g 1 // ���1
 * p 2 102 //��2��Ӧ�����ݸ���Ϊ102
 * p 3 3 //��3�ŵ������У���ʱ�����������轫������δʹ�õĵ����� �û���
 * g 2 // 2��������δʹ�ã���˴�ʱӦ�ò�����2 ��� -1
 */
