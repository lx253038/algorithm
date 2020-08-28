package String;

/**
 * @Author LX
 * @Date 2020/8/28 19:38
 * @Description 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
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
