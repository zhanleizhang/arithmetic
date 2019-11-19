package link;

public class LinkNodeList {
    public static void main(String[] args) {

        //准备数据
        LinkNode root = new LinkNode("火车头");
        LinkNode n1 = new LinkNode("车厢A");
        LinkNode n2 = new LinkNode("车厢B");

        // 链接节点
        root.setNext(n1);
        n1.setNext(n2);
        //获取节点列表
        getLinkNodeList(root);

        System.out.println("+++++++++++++++++++");
        //逆序列表
        LinkNode node = ReverLink.reverLinkList(root);
        getLinkNodeList(node);


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
