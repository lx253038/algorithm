package Queue;

import java.util.Stack;

/*ʹ��ջʵ�ֶ��е����в�����
        push(x) -- ��һ��Ԫ�ط�����е�β����
        pop() -- �Ӷ����ײ��Ƴ�Ԫ�ء�
        peek() -- ���ض����ײ���Ԫ�ء�
        empty() -- ���ض����Ƿ�Ϊ�ա�*/

class MyQueue {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);

        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println("[param_2:" + param_2 + "][param_3:" + param_3 + "][param_4:" + param_4 + "]");
    }


    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Stack<Integer> s = new Stack<>();
        while (!stack.isEmpty()) {
            s.push(stack.pop());
        }
        int result = s.pop();
        while (!s.isEmpty()) {
            stack.push(s.pop());
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.get(0);
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }
}