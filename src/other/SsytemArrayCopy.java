package other;

/**
 * System���ṩ��һ��native����arraycopy()
 */
public class SsytemArrayCopy {
    public static void main(String[] args) {
        User[] users = new User[]{new User(1, 3, "leizi", "8990000@qq.com"), new User(2, 8, "nimei", "9000000@qq,com"), new User(3, 7, "ta", "3333@qq,com")};
        User[] target = new User[users.length];
        //System.arraycopyһ��ǳ���Ʒ�ʽ
        System.arraycopy(users, 0, target, 0, users.length);
        System.out.println("Դ������Ŀ�����������ַ�Ƿ�һ����" + (users[0] == target[0] ? "ǳ����" : "���"));
        target[0].setEmail("8990000@sina.com");
        System.out.println("�޸�Ŀ����������ֵ��Դ����users��");
        for (User user : users) {
            System.out.println(user);
        }
    }
}

class User {
    private Integer id;
    private Integer age;
    private String username;
    private String email;


    public User() {
    }


    public User(Integer id, Integer age, String username, String email) {
        super();
        this.id = id;
        this.age = age;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

