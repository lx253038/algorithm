package String;

/**
 * @Author LX
 * @Date 2020/9/14 22:53
 * @Description ��һ����ƽ���ַ������У�'L' �� 'R' �ַ�����������ͬ�ġ�
 * <p>
 * ����һ��ƽ���ַ���?s�����㽫���ָ�ɾ����ܶ��ƽ���ַ�����
 * <p>
 * ���ؿ���ͨ���ָ�õ���ƽ���ַ��������������
 * ʾ�� 1��
 * ���룺s = "RLRRLLRLRL"
 * �����4
 * ���ͣ�s ���Էָ�Ϊ "RL", "RRLL", "RL", "RL", ÿ�����ַ����ж�������ͬ������ 'L' �� 'R'��
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
