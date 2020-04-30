package comparable;

public class User implements Comparable<User> {
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
    public int compareTo(User o) {
        int i = this.record - o.record; //先比较记录数大小
        if (i == 0) {
            return this.name.compareTo(o.name); //记录数相等在比较名字
        }
        return i;
    }
}
