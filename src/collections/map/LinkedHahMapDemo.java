package collections.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHahMapDemo {
    public static void main(String[] args) {
        /**
         * public LinkedHashMap() {
         *     // ����HashMap�Ĺ��췽������ʵ���ǳ�ʼ��Entry[] table
         *     super();
         *     // ������ָ�Ƿ���ڷ�������Ĭ��Ϊfalse
         *     accessOrder = false;
         *   }
         *   ����accessOrder����Ϊfalse����ʾ���Ƿ���˳����ǲ���˳��洢�ģ���Ҳ��Ĭ��ֵ��
         *   ��ʾLinkedHashMap�д洢��˳���ǰ��յ���put���������˳����������
         *   �ñ���Ϊtrueʱaccess-order����������˳����������Ϊfalse�����ʾ������˳�������Ĭ��Ϊfalse
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

        // ��������������ָ��accessOrderֵ
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        System.out.println("��ʼʱ˳��");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
        System.out.println("ͨ��get����������keyΪname1��Ӧ��Entry����β");
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
