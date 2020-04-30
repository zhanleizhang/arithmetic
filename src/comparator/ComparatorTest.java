package comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(new User("liming", 90),
                new User("xiaohong", 95),
                new User("zhoubin", 88),
                new User("xiaoli", 94)
        );
        // 1. 可以实现自己的外部接口进行排序 第一种方式
        Collections.sort(userList,new User());


        System.out.println(userList);

        // 2、 可以匿名内部类实现自定义排序 第二种方式
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getRecord() - user2.getRecord();
            }
        });
        System.out.println(userList);
    }
}