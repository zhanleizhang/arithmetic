package link;

/**
 * 链表节点
 */
public class LinkNode {
    private String data; //用于保存数据
    private LinkNode next;   //用于保存下一个节点

    public LinkNode(String data) {  //每一个Node类对象都必须保存有数据
        this.data = data;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode getNext() {
        return this.next;
    }

    public String getData() {
        return this.data;
    }

}
