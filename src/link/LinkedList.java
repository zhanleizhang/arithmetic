package link;

/**
 * 单链表实现
 *
 * @param <T>
 */
@SuppressWarnings("ALL")
public class LinkedList<T> {
    //头结点，头结点是为了方便在下面的方法中遍历链表用的
    public Node head = new Node(null);
    public int size;

    public LinkedList() {

    }

    /**
     * 获取元素值
     *
     * @param i
     * @return
     */
    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new ArrayIndexOutOfBoundsException("获取的位置不合法");
        } else {
            //把第一个节点给临时节点temp，让temp遍历
            Node temp = head;
            //counter用来计数，找到i在链表里的节点位置,头结点不算链表的真实节点，所以从-1开始计数
            int counter = -1;
            while (temp != null) {
                if (counter == i) {
                    return (T) temp.t;
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }

    /**
     * 添加元素
     *
     * @param t
     */
    public void add(T t) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(t);
        size++;
    }

    /**
     * 指定位置添加元素
     *
     * @param i
     * @param t
     */
    public void add(int i, T t) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("插入的位置不合法");
        } else {
            Node temp = head;
            int counter = -1;
            while (temp != null) {
                if ((i - 1) == counter) {
                    //将i前面的节点指向node，node的指向i节点
                    Node node = new Node(t);
                    Node back = temp.next;
                    temp.next = node;
                    node.next = back;
                    size++;
                }
                temp = temp.next;
                counter++;
            }
        }
    }


    /**
     * @param i
     */
    public void delete(int i) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("删除的位置不合法");
        } else {
            Node temp = head;
            int counter = -1;
            while (temp != null) {
                //将i前面的节点指向i后面的节点
                if ((i - 1) == counter) {
                    temp.next = temp.next.next;
                    size--;
                }
                counter++;
                temp = temp.next;
            }
        }
    }



    public static void main(String[] args) {
        LinkedList<Node> linkedList = new LinkedList<>();
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        linkedList.add(node);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        System.out.println(linkedList.size);
    }
}

