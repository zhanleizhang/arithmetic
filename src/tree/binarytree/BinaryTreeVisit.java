package tree.binarytree;

import java.util.Stack;

/**
 * ���к������������(�ݹ顢�ǵݹ�)
 */
public class BinaryTreeVisit {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * �������
     */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * �������
     */
    public static void preOrderFast(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        Node curNode;
        while (!s.isEmpty()) {
            curNode = s.pop();
            System.out.print(curNode.value + " ");
            // ջ�Ƚ�����������ȼ����Ҳ�ڵ㣬���������ʱ����������ڵ�
            if (curNode.right != null) {
                s.push(curNode.right);
            }
            if (curNode.left != null) {
                s.push(curNode.left);
            }
        }
    }

    /**
     * �������
     */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    /**
     * �������
     */
    public static void inOrderFast(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        Node curNode = root;
        while (!s.isEmpty() || curNode != null) {
            // ��ջ������ڵ㲢�����ڵ�
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.left;
            }

            // ������ڵ�
            curNode = s.pop();
            System.out.print(curNode.value + " ");
            // ������ָ��ǰ�ڵ���ҽڵ�
            curNode = curNode.right;
        }
    }

    /**
     * �������
     */
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * �������
     */
    public static void postOrderFast(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        Node curNode;
        while (!s1.isEmpty()) {

            curNode = s1.pop();
            // �С��ҡ���˳��ѹ��ջ��
            s2.push(curNode);

            // ѹ��s1Ϊ������ң���֤�С��ҡ���˳��ѹ��s2��
            if (curNode.left != null) {
                s1.push(curNode.left);
            }
            if (curNode.right != null) {
                s1.push(curNode.right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        System.out.println("PreOrder: ");
        preOrder(root);
        System.out.println("\nPreOrder: ");
        preOrderFast(root);

        System.out.println("\nInOrder: ");
        inOrder(root);
        System.out.println("\nInOrder: ");
        inOrderFast(root);

        System.out.println("\nPostOrder: ");
        postOrder(root);
        System.out.println("\nPostOrder: ");
        postOrderFast(root);
    }

    private static Node createBinaryTree() {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        root.left = node1;
        root.right = node2;

        Node node3 = new Node(3);
        node1.left = node3;

        Node node4 = new Node(4);
        node3.left = node4;

        return root;
    }

}