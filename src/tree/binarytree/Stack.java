package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Stack {
 
	static List<TreeNode> list = new ArrayList<>();
 
	/**
	 * �ж�ջ�Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public static boolean isEmpty() {
		return list.isEmpty();
	}
 
	/**
	 * ��ջ
	 * 
	 */
	public static TreeNode pull() {
		TreeNode node = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return node;
	}
 
	/**
	 * ����ջ
	 * 
	 * @param node
	 */
	public static void push(TreeNode node) {
		list.add(node);
	}
 
}