package tree.binarytree;

import java.util.Stack;

/**
 * 先中后序遍历二叉树(递归、非递归)
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
     * 先序遍历
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
     * 先序遍历
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
            // 栈先进后出，所以先加入右侧节点，这样输出的时候，先输出左侧节点
            if (curNode.right != null) {
                s.push(curNode.right);
            }
            if (curNode.left != null) {
                s.push(curNode.left);
            }
        }
    }

    /**
     * 中序遍历
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
     * 中序遍历
     */
    public static void inOrderFast(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        Node curNode = root;
        while (!s.isEmpty() || curNode != null) {
            // 入栈所有左节点并输出左节点
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.left;
            }

            // 弹出左节点
            curNode = s.pop();
            System.out.print(curNode.value + " ");
            // 弹出后，指向当前节点的右节点
            curNode = curNode.right;
        }
    }

    /**
     * 后序遍历
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
     * 后序遍历
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
            // 中、右、左顺序压入栈中
            s2.push(curNode);

            // 压入s1为先左后右，保证中、右、左顺序压入s2中
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