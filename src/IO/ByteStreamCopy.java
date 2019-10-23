package IO;

import java.io.*;

/**
 * @Author LX
 * @Date 2019/10/21 19:17
 * @Description �ֽ��������ļ�
 * ͨ��FileInputStream�ļ�������  FileOutputStream�ļ������ ʵ���ļ��Ŀ���
 */
public class ByteStreamCopy {

    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("photo.png");
            outputStream = new FileOutputStream("copyPh.jpg");

            System.out.println(inputStream.available() / 1024 + "kb");//��ȡ�ļ���С

            byte[] bytes = new byte[1024];  //�����ֽ������ȡ��
            int read;
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);   //ͨ����������ֽ�д���ļ�
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
