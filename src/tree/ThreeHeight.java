package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ThreeHeight {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //�ݹ����ĸ߶�
        System.out.println(getHeight1(root));

    }

    /**
     * �ݹ����ĸ߶� ,��α���
     * ����
     *
     * @param root
     * @return
     */
    private static int getHeight(TreeNode root) {
        if (null == root)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(rightHeight, leftHeight) + 1;
    }

    private static int getHeight1(TreeNode root) {
        if (null == root)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (queue.size() > 0) {
            //��ȡ��ǰ�㼶�Ľڵ���
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                break;
            }
            //�߶ȼ�1
            height++;

            //ȡ�����Ƴ���ǰ�㼶�Ľڵ���
            while (nodeCount > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;

            }
        }
        return height;
    }
}
