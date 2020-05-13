package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeepBroad {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        head.right = three;
        head.left = second;
        second.right = five;
        second.left = four;
        three.right = seven;
        three.left = six;
        System.out.println("broad优先遍历结果：");
        new DeepFirstSort().broadFirstSearch(head);
        System.out.println();
        System.out.println("deep优先遍历结果：");
        new DeepFirstSort().depthFirstSearch(head);
        new DeepFirstSort().depthFirstSearch1(head);
        new DeepFirstSort().midTreeSearch(head);
        new DeepFirstSort().inorderTraversal(head);
        new DeepFirstSort().postTreeSearch(head);
    }
}

class DeepFirstSort {


    /**
     * 广度优先遍历，用队列，层级遍历
     *
     * @param head
     */
    public void broadFirstSearch(TreeNode head) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.print(pop.val + " ");
            if (pop.left != null)
                queue.add(pop.left);
            if (pop.right != null)
                queue.add(pop.right);
        }

    }

    /**
     * 深度遍历，栈  和二叉树前序
     *
     * @param head
     */
    public void depthFirstSearch(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                System.out.print(head.val + " ");
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop();
                head = head.right;
            }
        }
    }

    /**
     * 深度遍历也是一种前序遍历
     *
     * @param head
     */
    public void depthFirstSearch1(TreeNode head) {
        System.out.println();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public void midTreeSearch(TreeNode head) {
        System.out.println();
        System.out.println("中序遍历");
        Stack<TreeNode> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }

            // if (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + " ");
            head = head.right;
            // }
        }
    }

    public void inorderTraversal(TreeNode root) {
        System.out.println();
        System.out.println("中序遍历");
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    /**
     * 后序排列 结果显示的是：左 右 中
     * 两个栈，一个存储节点的位置 中 右 左
     * 一个存储栈弹出的节点信息左 右 中
     * @param head
     */
    public void postTreeSearch(TreeNode head) {
        System.out.println();
        System.out.println("后序排列");
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {

            head = stack1.pop();
            //存储中右左
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        /**
         * 弹出 左 右 中
         */
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }

    }

}
