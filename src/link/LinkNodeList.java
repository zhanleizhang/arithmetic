package link;

public class LinkNodeList {
    public static void main(String[] args) {

        //׼������
        LinkNode root = new LinkNode("��ͷ");
        LinkNode n1 = new LinkNode("����A");
        LinkNode n2 = new LinkNode("����B");
        LinkNode n3 = new LinkNode("����C");
        LinkNode n4 = new LinkNode("����D");
        LinkNode n5 = new LinkNode("����E");

        // ���ӽڵ�
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        //��ȡ�ڵ��б�
        getLinkNodeList(root);

        System.out.println("+++++++++++++++++++");
        //�����б�
       /* LinkNode node = ReverLink.reverLinkList(root);
        getLinkNodeList(node);*/

        LinkNode nodek = KNodeLink.kNodeLink(root,2);
        System.out.println(nodek.getData());
        LinkNode nodek1 = KNodeLink.kNodeLink1(root,2);
        System.out.println(nodek1.getData());


    }

    private static void getLinkNodeList(LinkNode root) {
        //�ڶ�����ȡ����������
        LinkNode currentLinkNode = root;  //�ӵ�ǰ���ڵ㿪ʼ��ȡ
        while (currentLinkNode != null) {
            System.out.println(currentLinkNode.getData());
            //����һ���ڵ�����Ϊ��ǰ�ڵ�s
            currentLinkNode = currentLinkNode.getNext();
        }
    }
}
