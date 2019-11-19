package stack;

import java.util.Stack;

/**
 * 涉及getMain功能的栈
 * 栈，先进后出
 * 两个栈，一个存储最小的
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
    }

    public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(int newNum) {
        this.stackData.push(newNum);
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (this.stackMin.peek() > newNum) {
            this.stackMin.push(newNum);
        }
    }

    public void getStackNums() {
        System.out.println("最小栈列表");
        while (this.stackMin.size() > 0) {
            System.out.println(this.stackMin.pop());
        }
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("the stach is empty");
        }
        int num = this.stackData.pop();
        if (num == this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return 0;
    }

    public int getMain() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("the stach is empty");
        }
        return this.stackMin.peek();
    }
}

