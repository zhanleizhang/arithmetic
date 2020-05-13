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
        System.out.println("broad���ȱ��������");
        new DeepFirstSort().broadFirstSearch(head);
        System.out.println();
        System.out.println("deep���ȱ��������");
        new DeepFirstSort().depthFirstSearch(head);
        new DeepFirstSort().depthFirstSearch1(head);
        new DeepFirstSort().midTreeSearch(head);
        new DeepFirstSort().inorderTraversal(head);
        new DeepFirstSort().postTreeSearch(head);
    }
}

class DeepFirstSort {


    /**
     * ������ȱ������ö��У��㼶����
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
     * ��ȱ�����ջ  �Ͷ�����ǰ��
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
     * ��ȱ���Ҳ��һ��ǰ�����
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
        System.out.println("�������");
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
        System.out.println("�������");
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
     * �������� �����ʾ���ǣ��� �� ��
     * ����ջ��һ���洢�ڵ��λ�� �� �� ��
     * һ���洢ջ�����Ľڵ���Ϣ�� �� ��
     * @param head
     */
    public void postTreeSearch(TreeNode head) {
        System.out.println();
        System.out.println("��������");
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {

            head = stack1.pop();
            //�洢������
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        /**
         * ���� �� �� ��
         */
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }

    }

}
