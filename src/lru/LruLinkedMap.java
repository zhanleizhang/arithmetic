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
     * @description ��дLinkedHashMap�е�removeEldestEntry��������LRU��Ԫ�ض���6��ʱ��
     *              ɾ�������ʹ�õ�Ԫ��
     */
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        if(size() > size){
            return true;
        }
        return false;
    }

}