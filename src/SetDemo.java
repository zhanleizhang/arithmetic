import java.util.HashSet;

public class SetDemo {
    public static void main(String[] args) {
        //set返回第一个元素
        HashSet<String> set = new HashSet<>();
        //当set里面的值没空是，将会报出java.util.NoSuchElementException
        set.add("lei");
        System.out.println(set.iterator().next());

        /*
        最好加上判断先判断是否为空
        Iterator<String> it = set.iterator();
        if(it.hasNext()) it.next();
         */

    }
}
