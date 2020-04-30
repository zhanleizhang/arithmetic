package link;

public class LinkNodeList {
    public static void main(String[] args) {

        //准备数据
        LinkNode root = new LinkNode("火车头");
        LinkNode n1 = new LinkNode("车厢A");
        LinkNode n2 = new LinkNode("车厢B");
        LinkNode n3 = new LinkNode("车厢C");
        LinkNode n4 = new LinkNode("车厢D");
        LinkNode n5 = new LinkNode("车厢E");

        // 链接节点
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        //获取节点列表
        getLinkNodeList(root);

        System.out.println("+++++++++++++++++++");
        //逆序列表
       /* LinkNode node = ReverLink.reverLinkList(root);
        getLinkNodeList(node);*/

        LinkNode nodek = KNodeLink.kNodeLink(root,2);
        System.out.println(nodek.getData());
        LinkNode nodek1 = KNodeLink.kNodeLink1(root,2);
        System.out.println(nodek1.getData());


    }

    private static void getLinkNodeList(LinkNode root) {
        //第二步：取出所有数据
        LinkNode currentLinkNode = root;  //从当前根节点开始读取
        while (currentLinkNode != null) {
            System.out.println(currentLinkNode.getData());
            //将下一个节点设置为当前节点s
            currentLinkNode = currentLinkNode.getNext();
        }
    }
}
