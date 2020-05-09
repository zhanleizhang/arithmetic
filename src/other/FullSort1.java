package other;

import java.util.Stack;

/**
 * 全排列，用stack实现
 */
public class FullSort1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        full(arr, new Stack<>());
    }

    /**
     * 深度遍历加上回溯
     *
     * @param array
     * @param stack
     */
    public static void full(int[] array, Stack<Integer> stack) {
        if (array.length <= 0) {
            System.out.println(stack);
        } else {
            for (int i = 0; i < array.length; i++) {
                int[] tempArray = new int[array.length - 1];
                //浅复制
                System.arraycopy(array, 0, tempArray, 0, i);
                System.arraycopy(array, i + 1, tempArray, i, array.length - i - 1);
                stack.push(array[i]);
                full(tempArray, stack);
                stack.pop();
            }
        }
    }
}

