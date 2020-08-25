package String;

/**
 * @Author LX
 * @Date 2020/8/21 20:32
 * @Description 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * 示例 1：
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 */
public class LeetCode1456 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1456().maxVowels("", 3));
    }

    public int maxVowels(String s, int k) {

        int max = 0, curr = 0, left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                curr++;
            }
            if (right - left == k) {
                max = Math.max(max, curr);
                c = s.charAt(left++);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    curr--;
                }
            }
        }
        return max;
    }
}
