package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	static List<TreeNode> list = new ArrayList<>();
 
	/**
	 * 入队
	 * 
	 * @param node
	 */
	public static void in(TreeNode node) {
		list.add(node);
	}
 
	/**
	 * 出队
	 */
	public static TreeNode out() {
		TreeNode tem = list.get(0);
		list.remove(0);
		return tem;
	}
 
	/**
	 * 判读队列是否为空
	 * 
	 * @return
	 */
	public static boolean isEmpty() {
		return list.isEmpty();
	}
}
