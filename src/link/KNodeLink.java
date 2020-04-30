package link;

/**
 * µ¹ÊýµÚk¸ö
 */
public class KNodeLink {
    public static LinkNode kNodeLink(LinkNode head, int k) {
        LinkNode node1 = head;
        LinkNode node2 = head;
        while (node1 != null) {
            node1 = node1.getNext();
            k--;
        }

        while (k < 0) {
            node2 = node2.getNext();
            k++;
        }
        return node2;
    }

    public static LinkNode kNodeLink1(LinkNode head, int k) {
        LinkNode node1 = head;
        LinkNode node2 = head;
        while (node1 != null && k > 0) {
            node1 = node1.getNext();
            k--;
        }

        while (node1!=null) {
            node2 = node2.getNext();
            node1 = node1.getNext();
        }
        return node2;
    }
}
