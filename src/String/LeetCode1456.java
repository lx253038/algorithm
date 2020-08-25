package String;

/**
 * @Author LX
 * @Date 2020/8/21 20:32
 * @Description �����ַ��� s ������ k ��
 * �뷵���ַ��� s �г���Ϊ k �ĵ������ַ����п��ܰ��������Ԫ����ĸ����
 * Ӣ���е� Ԫ����ĸ Ϊ��a, e, i, o, u����
 * ʾ�� 1��
 * ���룺s = "abciiidef", k = 3
 * �����3
 * ���ͣ����ַ��� "iii" ���� 3 ��Ԫ����ĸ��
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
