package link;

/**
 * ����ڵ�
 */
public class LinkNode {
    private String data; //���ڱ�������
    private LinkNode next;   //���ڱ�����һ���ڵ�

    public LinkNode(String data) {  //ÿһ��Node����󶼱��뱣��������
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
