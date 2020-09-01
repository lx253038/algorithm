package Stack;

import java.util.Stack;

/**
 * @Author
 * @Date 2020/8/31 20:46
 * @Description 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括?+,?-,?*,?/?。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例?1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
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
