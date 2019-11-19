package stack;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stackData = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();
        MyStack1 stack1 = new MyStack1(stackData, stackMin);
        int[] arr = {7, 4, 3, 1, 0, 5, 2, 12, 6};
        for (int i = 0; i < arr.length; i++) {
            stack1.push(arr[i]);
        }

        System.out.println("×îÐ¡Öµ£º" + stack1.getMain());

        stack1.getStackNums();
    }
}
