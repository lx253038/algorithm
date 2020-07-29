package String;

/**
 * @Author LX
 * @Date 2020/7/29 21:23
 * @Description ����һ����������Сд��ĸ�Ϳո�?' '?���ַ��� s�����������һ�����ʵĳ��ȡ�����ַ����������ҹ�����ʾ����ô���һ�����ʾ��������ֵĵ��ʡ�
 * ������������һ�����ʣ��뷵�� 0?��
 * ˵����һ��������ָ������ĸ��ɡ��������κοո��ַ��� ������ַ�����
 * ʾ��:
 * ����: "Hello World"
 * ���: 5
 */
public class LeetCode58 {
    public static void main(String[] args) {
        System.out.println(new LeetCode58().lengthOfLastWord2(" h  "));
    }

    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        if (s1.length == 0) {
            return 0;
        }
        return s1[s1.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
