package link;

public class LinkNodeList {
    public static void main(String[] args) {

        //׼������
        LinkNode root = new LinkNode("��ͷ");
        LinkNode n1 = new LinkNode("����A");
        LinkNode n2 = new LinkNode("����B");

        // ���ӽڵ�
        root.setNext(n1);
        n1.setNext(n2);
        //��ȡ�ڵ��б�
        getLinkNodeList(root);

        System.out.println("+++++++++++++++++++");
        //�����б�
        LinkNode node = ReverLink.reverLinkList(root);
        getLinkNodeList(node);


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
