package IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author LX
 * @Date 2019/10/19 12:02
 * @Description fileReader���ַ�������
 */
public class FileReaderDemo {

    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            int len;
            fileReader = new FileReader("demo.txt");
            /* int read = fileReader.read();//һ���ַ�һ���ַ���ȡ  һ��ֻ��ȡһ���ַ���������-1ʱ��ʾ�Ѷ�ȡ���*/
/*            while ((len = fileReader.read()) != -1) {  //ѭ��ȥ��ȡ�����ַ���֪�����ؽ��Ϊ-1���ж����ַ�ѭ�����ٴΣ�
                System.out.print((char) len);
            }*/

            char[] arr = new char[16];      //��ÿ�ζ�ȡ���ַ��ŵ��ַ������У�
/*            int read = fileReader.read(arr);  //read���ض�ȡ�ַ��ĸ���,��ÿ������ȡ����Ϊ���鳤��
            System.out.println(new String(arr, 0, read));*/
            //���ڲ�ȷ�����������ַ��������ܳ������鳤��С���ַ�����һ�β���ȫ����ȡ��
            //ʹ��whileѭ��ȫ����ȡ
            while ((len = fileReader.read(arr)) != -1) {
                System.out.print(new String(arr, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
