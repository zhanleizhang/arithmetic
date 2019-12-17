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
 * 非递归遍历
 * @author Administrator
 *
 */
public class NoOrder {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = init();
		System.out.println("非递归先序遍历");
		NoProOrder(root);
		System.out.println("非递归中序遍历");
		NoInOrder(root);
		System.out.println("层次遍历");
		levelOrder(root);
		/*System.out.println("非递归后序遍历");//写的不太对怎么
		NoPostOrder(root);*/
 
	}
 
	/** 构造树 */
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
	 * 非递归先序遍历
	 * 
	 * @param node
	 */
	public static void NoProOrder(TreeNode node) {
		// 创建队列
		Stack stack = new Stack();
		while (!stack.isEmpty() || node != null) {// 当栈不为空
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
		// 创建队列
		Stack stack = new Stack();
		while (!stack.isEmpty() || node != null) {// 当栈不为空
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
	 * 后续遍历，后续遍历的过程比稍微复杂一些，需要用到两个栈来实现
	 * 
	 * @param node
	 */
	public static void NoPostOrder(TreeNode node) {
		// 创建队列
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		stack1.push(node);
		while (!stack1.isEmpty()) {
			node = stack1.pull();
			stack2.push(node);
			// 有左孩子就先压入左孩子
			if (node.left != null)
				stack1.push(node.left);
			// 有右孩子就后压入右孩子
			if (node.right != null)
				stack1.push(node.right);
		}
		// 逆序打印 根 -> 右 -> 左 的结果，就是后序遍历的结果
		while (!stack2.isEmpty())
			System.out.print(stack2.pull().value + " ");
	}
 
	/**
	 * 层次遍历
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
	 * 层次遍历 对列
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