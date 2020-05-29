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
     * 1 2 3    4 5
     * 解析：递归遍历
     * head 等于null 或者head.getNext为空作为函数终止条件
     * 当它们不等于null时，进行递归操作
     * reverLinkList1(head.getNext()); 当head.getNext()是最后一个节点5时，直接返回newHead
     * head.getNext().setNext(head); 把节点5的下一个节点设置成4就是当前head节点，它们两个节点反转
     * head.setNext(null) 断开head的下一个指向，新旧链表断开，第一次4断开5
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
