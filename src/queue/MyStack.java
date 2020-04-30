package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        System.out.println("MyStack");
    }

    public boolean push(Integer num) {
        return q1.offer(num);
    }

    public Integer pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        // 先判断 q1 是否为空 
        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                q2.offer(q1.poll());
            }
            Integer a = q1.poll();
           // System.out.println("pop-----1"+a);
            return a;
        } else {
            int size = q2.size();
            for (int i = 0; i < size - 1; i++) {
                q1.offer(q2.poll());
            }
            Integer a = q1.poll();
            //System.out.println("pop-----2"+a);
            return a;
            //return q2.poll();
        }
    }

    public Integer top() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        // 先判断 q1 是否为空
        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                q2.offer(q1.poll());
            }
            Integer a = q1.poll();
            q2.offer(a);
            return a;
        } else {
            int size = q2.size();
            for (int i = 0; i < size - 1; i++) {
                q1.offer(q2.poll());
            }
            Integer a = q2.poll();
            q1.offer(a);
            return a;
        }
    }

    public Boolean isEmpty()
    {
        return q1.isEmpty()&&q2.isEmpty();
    }

    public Integer size() {
        return q1.size() + q2.size();
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);


        /*int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }*/
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

    }
}