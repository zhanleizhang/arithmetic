package link;

/**
 * ��������
 */
public class ReverLink {
    public static LinkNode reverLinkList(LinkNode head) {
        if (null == head) {
            return null;
        }
        //ǰ���ڵ�
        LinkNode pre = null;
        //���ýڵ�
        LinkNode next = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * �ݹ������ת����
     *
     * 1 2 3    4 5
     * �������ݹ����
     * head ����null ����head.getNextΪ����Ϊ������ֹ����
     * �����ǲ�����nullʱ�����еݹ����
     * reverLinkList1(head.getNext()); ��head.getNext()�����һ���ڵ�5ʱ��ֱ�ӷ���newHead
     * head.getNext().setNext(head); �ѽڵ�5����һ���ڵ����ó�4���ǵ�ǰhead�ڵ㣬���������ڵ㷴ת
     * head.setNext(null) �Ͽ�head����һ��ָ���¾�����Ͽ�����һ��4�Ͽ�5
     *
     * @param head
     * @return
     */
    public static LinkNode reverLinkList1(LinkNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        LinkNode newHead = reverLinkList1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;

    }
}
