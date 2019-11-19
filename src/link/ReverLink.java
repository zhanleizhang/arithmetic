package link;

/**
 * Á´±íÄæĞò
 */
public class ReverLink {
    public static LinkNode reverLinkList(LinkNode head) {
        if (null == head) {
            return null;
        }
        LinkNode pre = null;  //Ç°Çı
        LinkNode next = null; //ºóÖÃ
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }
}
