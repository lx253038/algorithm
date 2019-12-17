package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author LX
 * @Date 2019/10/21 21:08
 * @Description ģ��Ӽ��������ַ�����ȡ
 */
public class SystemInDeno {

    public static void main(String[] args) throws IOException {
        demo1();
        //demo2();
        //demo3();
    }

    private static void demo3() {
        Scanner s = new Scanner(System.in);
        while (true) {
            String s1 = s.nextLine();
            if ("over".equals(s1)) {
                break;
            }
            System.out.println(s1.toUpperCase());
        }

    }

    private static void demo2() throws IOException {
        InputStream inputStream = System.in;  //��ȡ����������
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);  //�����ֽ�ת�����ַ���
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  //�����ַ�����
        String str;
        while ((str = bufferedReader.readLine()) != null) {   //ͨ���ַ�������readLine()���ж�ȡ
            if ("over".equals(str)) {
                return;
            }
            System.out.println(str.toUpperCase());
        }

    }

    private static void demo1() throws IOException {
        InputStream inputStream = System.in;
        int read;
        while ((read = inputStream.read()) != -1) {
            System.out.println(read);  //�޷�������ÿ�ζ����س����ж�ȡ����
        }

    }

}
