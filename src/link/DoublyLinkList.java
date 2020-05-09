package link;


import java.io.IOException;


public class DoublyLinkList<T> {
    private Link<T> frist;
    private Link<T> last;

    public DoublyLinkList() {//��ʼ����βָ��
        frist = null;
        last = null;
    }

    public boolean isEmpty() {
        return frist == null;
    }

    public void addFrist(T value) {
        Link<T> newLink = new Link(value);
        if (isEmpty()) { // �������Ϊ��
            last = newLink; //last -> newLink
        } else {
            frist.pre = newLink; // frist.pre -> newLink
        }
        newLink.next = frist; // newLink -> frist
        frist = newLink; // frist -> newLink
    }

    public void addLast(T value) {
        Link<T> newLink = new Link(value);
        if (isEmpty()) { // �������Ϊ��
            frist = newLink; // ��ͷָ��ֱ��ָ���½ڵ�
        } else {
            last.next = newLink; //lastָ��Ľڵ�ָ���½ڵ�
            newLink.pre = last; //�½ڵ��ǰ��ָ��lastָ��
        }
        last = newLink; // lastָ���½ڵ�
    }

    public boolean addBefore(T key, T value) {

        Link<T> cur = frist;
        if (frist.next.val == key) {
            addFrist(value);
            return true;
        } else {
            while (cur.next.val != key) {
                cur = cur.next;
                if (cur == null) {
                    return false;
                }
            }
            Link<T> newLink = new Link(value);
            newLink.next = cur.next;
            cur.next.pre = newLink;
            newLink.pre = cur;
            cur.next = newLink;
            return true;
        }
    }

    public void addAfter(T key, T value) throws RuntimeException {
        Link<T> cur = frist;
        while (cur.val != key) { //����ѭ����curָ��ָ��ָ���ڵ�
            cur = cur.next;
            if (cur == null) { // �Ҳ����ýڵ�
                throw new RuntimeException("Node is not exists");
            }
        }
        Link<T> newLink = new Link<>(value);
        if (cur == last) { // �����ǰ�����β�ڵ�
            newLink.next = null; // �½ڵ�ָ��null
            last = newLink; // lastָ��ָ���½ڵ�
        } else {
            newLink.next = cur.next; //�½ڵ�nextָ�룬ָ��ǰ����next
            cur.next.pre = newLink; //��ǰ����ǰ��ָ���½ڵ�
        }
        newLink.pre = cur;//��ǰ����ǰ��ָ��ǰ���
        cur.next = newLink; //��ǰ���ĺ��ָ���½ڵ�
    }

    public void deleteFrist() {
        if (frist.next == null) {
            last = null;
        } else {
            frist.next.pre = null;
        }
        frist = frist.next;
    }

    public void deleteLast(T key) {
        if (frist.next == null) {
            frist = null;
        } else {
            last.pre.next = null;
        }
        last = last.pre;
    }

    public void deleteKey(T key) throws RuntimeException {
        Link<T> cur = frist;
        while (cur.val != key) {
            cur = cur.next;
            if (cur == null) { //�����ڸýڵ�
                throw new RuntimeException("Node is not exists");
            }
        }
        if (cur == frist) { // ���fristָ��Ľڵ�
            frist = cur.next; //fristָ�����
        } else {
            cur.pre.next = cur.next;//ǰ��ڵ�ĺ��ָ��ǰ�ڵ�ĺ�һ���ڵ�
        }
        if (cur == last) { // �����ǰ�ڵ���β�ڵ�
            last = cur.pre; // β�ڵ��ǰ��ǰ��
        } else {
            cur.next.pre = cur.pre; //����ڵ��ǰ��ָ��ǰ�ڵ��ǰһ���ڵ�
        }
    }

    public T queryPre(T value) throws IOException, RuntimeException {
        Link<T> cur = frist;
        if (frist.val == value) {
            throw new RuntimeException("Not find " + value + "pre");
        }
        while (cur.next.val != value) {
            cur = cur.next;
            if (cur.next == null) {
                throw new RuntimeException(value + " pre is not exeist!");
            }
        }

        return cur.val;
    }

    public void displayForward() {
        Link<T> cur = frist;
        while (cur != null) {
            cur.displayCurrentNode();
            cur = cur.next;
        }
        System.out.println();

    }

    public void displayBackward() {
        Link<T> cur = last;
        while (cur != null) {
            cur.displayCurrentNode();
            cur = cur.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        DoublyLinkList<Integer> d = new DoublyLinkList<>();
        d.addFrist(1);
//        d.addFirst(1);
        d.addFrist(2);
        d.addFrist(3);
        d.addLast(6);
        d.addFrist(4);
        d.addFrist(5);
        d.addLast(7);
        d.displayForward();
        System.out.println(d.queryPre(4));
        System.out.println(d.queryPre(0));
    }
}

class Link<T> {
    public T val;
    public Link<T> next;
    public Link<T> pre;

    public Link(T val) {
        this.val = val;
    }

    public void displayCurrentNode() {
        System.out.print(val + "  ");
    }
}