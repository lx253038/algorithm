package String;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2020/9/17 19:02
 * @Description ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 * ʾ��?1:
 * ����: s = "anagram", t = "nagaram"
 * ���: true
 * ʾ�� 2:
 * ����: s = "rat", t = "car"
 * ���: false
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.equals(schars, tchars);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[] arr = new int[26];
        for (int i = 0; i < schars.length; i++) {
            arr[schars[i] - 'a']++;
            arr[tchars[i] - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode242().isAnagram2("anagram", "nagaram"));
    }

}
