package Stack;

import java.util.Stack;

/**
 * @Author
 * @Date 2020/8/31 20:46
 * @Description ���� �沨����ʾ��������ʽ��ֵ��
 * ��Ч�����������?+,?-,?*,?/?��ÿ��������������������Ҳ��������һ���沨�����ʽ��
 * ˵����
 * ��������ֻ�����������֡�
 * �����沨�����ʽ������Ч�ġ����仰˵�����ʽ�ܻ�ó���Ч��ֵ�Ҳ����ڳ���Ϊ 0 �������
 * ʾ��?1��
 * ����: ["2", "1", "+", "3", "*"]
 * ���: 9
 * ����: ����ʽת��Ϊ��������׺�������ʽΪ��((2 + 1) * 3) = 9
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String curr : tokens) {
            switch (curr) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int a = stack.pop();
                    stack.push(stack.pop() - a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int b = stack.pop();
                    stack.push(stack.pop() / b);
                    break;
                default:
                    stack.push(Integer.valueOf(curr));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode150().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

}
