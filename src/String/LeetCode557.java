package String;

/**
 * @Author LX
 * @Date 2020/8/28 19:38
 * @Description 557. ��ת�ַ����еĵ��� III
 * ����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
 * ʾ����
 * ���룺"Let's take LeetCode contest"
 * �����"s'teL ekat edoCteeL tsetnoc"
 */
public class LeetCode557 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(new StringBuffer(strs[i]).reverse().toString() + " ");
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode557().reverseWords("Let's take LeetCode contest"));
    }
}
