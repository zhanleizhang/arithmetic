package lru;

import java.util.LinkedHashMap;

public class LruLinkedMap<K,V> extends LinkedHashMap<K,V> {

    private int size;

    public LruLinkedMap(int initialCapacity,
               float loadFactor,
               boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        this.size = initialCapacity;
    }

    /**
     * @description 重写LinkedHashMap中的removeEldestEntry方法，当LRU中元素多余6个时，
     *              删除最不经常使用的元素
     */
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        if(size() > size){
            return true;
        }
        return false;
    }

}