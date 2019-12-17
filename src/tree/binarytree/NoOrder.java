package tree.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
       				 H
					/ \
				   D   G
				  / \   \
				 B  C    F
				 \      /
				  A	   E
*/
/*
 * �ǵݹ����
 * @author Administrator
 *
 */
public class NoOrder {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = init();
		System.out.println("�ǵݹ��������");
		NoProOrder(root);
		System.out.println("�ǵݹ��������");
		NoInOrder(root);
		System.out.println("��α���");
		levelOrder(root);
		/*System.out.println("�ǵݹ�������");//д�Ĳ�̫����ô
		NoPostOrder(root);*/
 
	}
 
	/** ������ */
	public static TreeNode init() {
		TreeNode a = new TreeNode('A');
		TreeNode b = new TreeNode('B', null, a);
		TreeNode c = new TreeNode('C');
		TreeNode d = new TreeNode('D', b, c);
		TreeNode e = new TreeNode('E');
		TreeNode f = new TreeNode('F', e, null);
		TreeNode g = new TreeNode('G', null, f);
		TreeNode h = new TreeNode('H', d, g);
		return h;// root
	}
 
	/**
	 * �ǵݹ��������
	 * 
	 * @param node
	 */
	public static void NoProOrder(TreeNode node) {
		// ��������
		Stack stack = new Stack();
		while (!stack.isEmpty() || node != null) {// ��ջ��Ϊ��
			while (node != null) {
				System.out.println(node.value);
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pull();
				node = node.right;
			}
		}
	}
 
	public static void NoInOrder(TreeNode node) {
		// ��������
		Stack stack = new Stack();
		while (!stack.isEmpty() || node != null) {// ��ջ��Ϊ��
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pull();
				System.out.println(node.value);
				node = node.right;
			}
		}
	}
 
	/**
	 * �������������������Ĺ��̱���΢����һЩ����Ҫ�õ�����ջ��ʵ��
	 * 
	 * @param node
	 */
	public static void NoPostOrder(TreeNode node) {
		// ��������
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		stack1.push(node);
		while (!stack1.isEmpty()) {
			node = stack1.pull();
			stack2.push(node);
			// �����Ӿ���ѹ������
			if (node.left != null)
				stack1.push(node.left);
			// ���Һ��Ӿͺ�ѹ���Һ���
			if (node.right != null)
				stack1.push(node.right);
		}
		// �����ӡ �� -> �� -> �� �Ľ�������Ǻ�������Ľ��
		while (!stack2.isEmpty())
			System.out.print(stack2.pull().value + " ");
	}
 
	/**
	 * ��α���
	 * 
	 * @param node
	 */
	public static void levelOrder(TreeNode node) {
		Queue queue = new Queue();
		while (!queue.isEmpty() || node != null) {
			if (node != null) {
				System.out.println(node.value);
				queue.in(node.left);
				queue.in(node.right);
			}
			node = queue.out();
 
		}
	}

	/**
	 * ��α��� ����
	 * @param root
	 * @return
	 */
	public List<Integer> levelOrderBT(TreeNode root) {
		List<Integer> levelResult = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		if (root==null)
			return levelResult;
		deque.addLast(root);
		TreeNode currentNode = root;
		while (!deque.isEmpty()){
			currentNode = deque.pollFirst();
			if (currentNode.left!=null)
				deque.addLast(currentNode.left);
			if (currentNode.right!=null)
				deque.addLast(currentNode.right);
			levelResult.add((int) currentNode.value);
		}
		return levelResult;

	}
 
}