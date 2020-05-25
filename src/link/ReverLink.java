package link;

/**
 * 逆序链表
 */
public class ReverLink {
    public static LinkNode reverLinkList(LinkNode head) {
        if (null == head) {
            return null;
        }
        //前驱节点
        LinkNode pre = null;
        //后置节点
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
     * 递归遍历反转链表
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
