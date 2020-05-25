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
