package comparator;

import java.util.Comparator;

public class AscComparator implements Comparator<User> {

    @Override
    public int compare(User stu1, User stu2) {

        // 根据成绩降序排列
        return stu1.getRecord() - stu2.getRecord();
    }

}
