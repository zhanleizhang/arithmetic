import java.util.HashSet;

public class SetDemo {
    public static void main(String[] args) {
        //set���ص�һ��Ԫ��
        HashSet<String> set = new HashSet<>();
        //��set�����ֵû���ǣ����ᱨ��java.util.NoSuchElementException
        set.add("lei");
        System.out.println(set.iterator().next());

        /*
        ��ü����ж����ж��Ƿ�Ϊ��
        Iterator<String> it = set.iterator();
        if(it.hasNext()) it.next();
         */

    }
}
