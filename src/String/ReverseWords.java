package String;

/**
 * @author LX
 * @date 2018-11-20 19:19
 */
/*����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
        ʾ��: ����: "the sky is blue",   ���: "blue is sky the".
        ˵��: �޿ո��ַ�����һ�����ʡ�
              �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
              ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
*/
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] s1 = s.split(" +");
        StringBuilder res = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            res.append(s1[i] + " ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(ReverseWords.reverseWords("1 "));
    }
}
