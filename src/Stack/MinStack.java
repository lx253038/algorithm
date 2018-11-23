package Stack;

import java.util.Stack;

/**
 * @author LX
 * @date 2018-11-23 14:30
 */
/*设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
        push(x) -- 将元素 x 推入栈中。 pop() -- 删除栈顶的元素。 top() -- 获取栈顶元素。 getMin() -- 检索栈中的最小元素。
 示例:  MinStack minStack = new MinStack();   minStack.push(-2);  minStack.push(0); minStack.push(-3);
        minStack.getMin();   --> 返回 -3.  minStack.pop(); minStack.top();      --> 返回 0. minStack.getMin();   --> 返回 -2.
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
