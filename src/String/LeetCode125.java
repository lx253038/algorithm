package String;

/**
 * @Author LX
 * @Date 2020/8/11 18:50
 * @Description ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 * ˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
 * ʾ�� 1:
 * ����: "A man, a plan, a canal: Panama"
 * ���: true
 * ʾ�� 2:
 * ����: "race a car"
 * ���: false
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
