package Stack;

import java.util.Stack;

/**
 * @Author LX
 * @Date 2020/8/31 21:16
 * @Description 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }

        String str = "";
        while (!stack.isEmpty()) {
            str = "/" + stack.pop() + str;
        }
        return str.isEmpty() ? "/" : str;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode71().simplifyPath("/a/../../b/../c//.//"));
    }
}
