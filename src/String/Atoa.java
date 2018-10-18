package String;
/*
该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
        示例 1：输入: "Hello"输出: "hello"
        示例 2：输入: "here"输出: "here"
        示例 3：输入: "LOVELY"输出: "lovely"
*/

public class Atoa {
    public String toLowerCase(String str) {
        StringBuffer result=new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            int a = Integer.valueOf(c);
            if (a >= 65 && a <= 90) {
                result.append((char)(a + 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Atoa atoa = new Atoa();
        System.out.println(atoa.toLowerCase("HellPPPPIIIIIUUUUoooookkkkkO"));
    }
}
