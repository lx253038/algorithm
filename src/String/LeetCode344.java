package String;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2020/8/11 19:07
 * @Description��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
 * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
 * ����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���
 * ���룺["h","e","l","l","o"]
 * �����["o","l","l","e","h"]
 */
public class LeetCode344 {

    public static void main(String[] args) {
        new LeetCode344().reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l <= r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }
}
