package String;

/**
 * @Author LX
 * @Date 2020/9/14 22:53
 * @Description 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给出一个平衡字符串?s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * 示例 1：
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 */
public class LeetCode1221 {

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        char currChar = chars[0];
        int currSize = 1;
        int size = 0;
        for (int i = 1; i < chars.length; i++) {
            if (currSize == 0) {
                size++;
                currChar = chars[i];
            }
            if (chars[i] == currChar) {
                currSize++;
            } else {
                currSize--;
            }

        }
        return ++size;
    }

    public int balancedStringSplit2(String s) {
        int num = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                n++;
            if (s.charAt(i) == 'L')
                n--;
            if (n == 0)
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1221().balancedStringSplit2("RLRRRLLRLL"));
    }
}
