package IO;

import java.io.*;

/**
 * @Author LX
 * @Date 2019/10/21 19:17
 * @Description 字节流拷贝文件
 * 通过FileInputStream文件输入流  FileOutputStream文件输出流 实现文件的拷贝
 */
public class ByteStreamCopy {

    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("photo.png");
            outputStream = new FileOutputStream("copyPh.jpg");

            System.out.println(inputStream.available() / 1024 + "kb");//获取文件大小

            byte[] bytes = new byte[1024];  //创建字节数组读取流
            int read;
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);   //通过输出流将字节写入文件
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
