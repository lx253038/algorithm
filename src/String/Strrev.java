package String;

/*
编写一个函数，其作用是将输入的字符串反转过来。
        示例 1:输入: "hello"输出: "olleh"
        示例 2:输入: "A man, a plan, a canal: Panama"输出: "amanaP :lanac a ,nalp a ,nam A"
*/

public class Strrev {
    public String reverseString(String s) {
/*        int len=s.length();
        char[] ch=new char[len];
        for(int i=0,j=len-1;i<len;i++,j--) {
            ch[i]=s.charAt(j);
        }
        return new String(ch);*/
        Character c1 = s.charAt(1);
        char c2 = s.charAt(1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return new String(chars);


    }

    public static void main(String[] args) {
        Strrev strrev = new Strrev();
        String result = strrev.reverseString("1234");
        System.out.println(result);
    }
}
