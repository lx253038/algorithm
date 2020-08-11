package String;

/**
 * @Author LX
 * @Date 2020/8/11 18:50
 * @Description 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class LeetCode125 {

    public static void main(String[] args) {
        System.out.println(new LeetCode125().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        if (chars.length < 2) {
            return true;
        }
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(chars[l])) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[r])) {
                r--;
                continue;
            }
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }
        return true;
    }

}
