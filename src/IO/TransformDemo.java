package IO;

import java.io.*;

/**
 * @Author LX
 * @Date 2019/10/22 18:38
 * @Description �ַ������ֽ����໥ת������
 */
public class TransformDemo {
    public static void main(String[] args) throws IOException {
        //1.����¼������д�뵽�ļ�
 /*       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test111.txt")));*/
        //2.���ı��������������̨
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test111.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));*/
        //2.���ļ������ݿ�������һ���ļ���
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test111.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy_test111.txt")));

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            if ("over".equals(str)) {
                break;
            }
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedReader.close();
        bufferedWriter.close();


    }

}
