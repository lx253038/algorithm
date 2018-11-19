package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LX
 * @date 2018-11-19 9:13
 */
/*ʹ�ö���ʵ��ջ�����в�����
   push(x) -- Ԫ�� x ��ջ
   pop() -- �Ƴ�ջ��Ԫ��
   top() -- ��ȡջ��Ԫ��
   empty() -- ����ջ�Ƿ�Ϊ��
ע��: ��ֻ��ʹ�ö��еĻ�������-- Ҳ���� push to back, peek/pop from front, size, �� is empty ��Щ�����ǺϷ��ġ�
      ����ʹ�õ�����Ҳ��֧�ֶ��С� �����ʹ�� list ���� deque��˫�˶��У���ģ��һ������ , ֻҪ�Ǳ�׼�Ķ��в������ɡ�
      ����Լ������в���������Ч�ģ�����, ��һ���յ�ջ������� pop ���� top ��������*/
public class MyStack {


    private Deque<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

        queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {


        return queue.removeLast();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.getLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
