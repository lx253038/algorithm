package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LX
 * @Date 2020/8/11 20:34
 * @Description ����һ���ַ����������ҳ����в������ظ��ַ���?��Ӵ�?�ĳ��ȡ�
 * ʾ��?1:
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
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
