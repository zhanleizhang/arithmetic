package comparator;

import java.util.Comparator;

public class User implements Comparator<User> {

    private String name;
    private int record;

    public User() {
    }

    public User(String name, int record) {
        this.name = name;
        this.record = record;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", record=" + record +
                '}';
    }
    @Override
    public int compare(User o1, User o2) {
        return o2.record-o1.record;
    }
}
