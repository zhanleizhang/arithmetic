package link;

/**
 * 单链表实现
 */
public class SingleLink {
    public static void main(String[] args) {
        Node<Integer> node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        while (node != null) {
            System.out.println(node.t);
            node = node.next;
        }

    }
}

class Node<T> {
    Node<T> next;
    T t;

    Node(T t) {
        this.t = t;
    }
}     