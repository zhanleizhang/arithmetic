package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	static List<TreeNode> list = new ArrayList<>();
 
	/**
	 * ���
	 * 
	 * @param node
	 */
	public static void in(TreeNode node) {
		list.add(node);
	}
 
	/**
	 * ����
	 */
	public static TreeNode out() {
		TreeNode tem = list.get(0);
		list.remove(0);
		return tem;
	}
 
	/**
	 * �ж������Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public static boolean isEmpty() {
		return list.isEmpty();
	}
}
