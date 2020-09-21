package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/9/21 18:36
 * @Description 数字 n?代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(""), list);
        return list;
    }

    public void dfs(int n, int left, int right, StringBuilder str, List<String> list) {
        if (str.length() == 2 * n) {
            list.add(str.toString());
            return;
        }

        if (left < n) {
            dfs(n, left + 1, right, str.append("("), list);
            str.deleteCharAt(str.length() - 1);
        }
        if (right < left) {
            dfs(n, left, right + 1, str.append(")"), list);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode22().generateParenthesis(3));
    }
}
