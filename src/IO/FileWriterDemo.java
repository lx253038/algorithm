package IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author LX
 * @Date 2019/10/19 12:02
 * @Description FileWriter �ַ������
 */
public class FileWriterDemo {


    private static final String LINE_FEED = System.getProperty("line.separator"); //��ȡϵͳ����

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("demo.txt", true);   //append �Ƿ���ԭ�������Ͻ���ƴ��
            fileWriter.write("abcdefg" + LINE_FEED + "1233");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
