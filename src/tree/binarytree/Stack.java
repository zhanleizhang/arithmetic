package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Stack {
 
	static List<TreeNode> list = new ArrayList<>();
 
	/**
	 * 判读栈是否为空
	 * 
	 * @return
	 */
	public static boolean isEmpty() {
		return list.isEmpty();
	}
 
	/**
	 * 出栈
	 * 
	 */
	public static TreeNode pull() {
		TreeNode node = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return node;
	}
 
	/**
	 * 出入栈
	 * 
	 * @param node
	 */
	public static void push(TreeNode node) {
		list.add(node);
	}
 
}