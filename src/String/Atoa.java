package String;
/*
�ú�������һ���ַ������� str���������ַ����еĴ�д��ĸת����Сд��ĸ��֮�󷵻��µ��ַ�����
        ʾ�� 1������: "Hello"���: "hello"
        ʾ�� 2������: "here"���: "here"
        ʾ�� 3������: "LOVELY"���: "lovely"
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
