package leetcode;

/**
 * @author: lixin
 * @date: 2021/12/29 9:45 обнГ
 * @description:
 */
public class LeetCode680 {


    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
