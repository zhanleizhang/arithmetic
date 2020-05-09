package link;

/**
 * ������ʵ��
 *
 * @param <T>
 */
@SuppressWarnings("ALL")
public class LinkedList<T> {
    //ͷ��㣬ͷ�����Ϊ�˷���������ķ����б��������õ�
    public Node head = new Node(null);
    public int size;

    public LinkedList() {

    }

    /**
     * ��ȡԪ��ֵ
     *
     * @param i
     * @return
     */
    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new ArrayIndexOutOfBoundsException("��ȡ��λ�ò��Ϸ�");
        } else {
            //�ѵ�һ���ڵ����ʱ�ڵ�temp����temp����
            Node temp = head;
            //counter�����������ҵ�i��������Ľڵ�λ��,ͷ��㲻���������ʵ�ڵ㣬���Դ�-1��ʼ����
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
     * ���Ԫ��
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
     * ָ��λ�����Ԫ��
     *
     * @param i
     * @param t
     */
    public void add(int i, T t) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("�����λ�ò��Ϸ�");
        } else {
            Node temp = head;
            int counter = -1;
            while (temp != null) {
                if ((i - 1) == counter) {
                    //��iǰ��Ľڵ�ָ��node��node��ָ��i�ڵ�
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
            throw new ArrayIndexOutOfBoundsException("ɾ����λ�ò��Ϸ�");
        } else {
            Node temp = head;
            int counter = -1;
            while (temp != null) {
                //��iǰ��Ľڵ�ָ��i����Ľڵ�
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

