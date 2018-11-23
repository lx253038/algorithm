package Stack;

import java.util.Stack;

/**
 * @author LX
 * @date 2018-11-23 14:30
 */
/*���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
        push(x) -- ��Ԫ�� x ����ջ�С� pop() -- ɾ��ջ����Ԫ�ء� top() -- ��ȡջ��Ԫ�ء� getMin() -- ����ջ�е���СԪ�ء�
 ʾ��:  MinStack minStack = new MinStack();   minStack.push(-2);  minStack.push(0); minStack.push(-3);
        minStack.getMin();   --> ���� -3.  minStack.pop(); minStack.top();      --> ���� 0. minStack.getMin();   --> ���� -2.
*/
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.empty()) {
            if (x < minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
