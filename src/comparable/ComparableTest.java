package comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    public static void main(String[] args) {
        List<User> studentList = Arrays.asList(new User("liming", 90),
                new User("xiaohong", 95),
                new User("zhoubin", 88),
                new User("zhouao", 88),
                new User("xiaoli", 94)
        );
		// ≈≈–Ú«∞
        System.out.println(studentList);
        Collections.sort(studentList);
        // ≈≈–Ú∫Û
        System.out.println(studentList);

        for(User User : studentList){
            System.out.println(User.equals(new User("xiaohong", 95)));
        }
    }
}