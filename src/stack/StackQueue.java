package stack;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class StackQueue {
    Stack<Integer> stackPush; //进对列
    Stack<Integer> stackPop;  //出队列

    public void add(int num) {
        this.stackPush.add(num);
    }

    public int poll() {
        if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (this.stackPop.isEmpty()) {
            while (!this.stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.pop();
    }

    public int peek() {
        if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (this.stackPop.isEmpty()) {
            while (!this.stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }


}
