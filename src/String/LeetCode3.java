package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LX
 * @Date 2020/8/11 20:34
 * @Description 给定一个字符串，请你找出其中不含有重复字符的?最长子串?的长度。
 * 示例?1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[255];
        int l = 0, r = 0, max = 0;
        while (l < s.length()) {
            if (r < s.length() && arr[s.charAt(r)] == 0) {
                arr[s.charAt(r++)]++;
            } else {
                arr[s.charAt(l++)]--;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, max = 0;
        while (l < s.length()) {
            if (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
            } else {
                set.remove(s.charAt(l++));
            }
            max = Math.max(max, r - l);
        }
        return max;
    }
}
