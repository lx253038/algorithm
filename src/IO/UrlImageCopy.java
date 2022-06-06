package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: lixin
 * @date: 2022/2/16 5:22 ����
 * @description:
 */
public class UrlImageCopy {

    public static final String imageURL = "https://img.bosszhipin.com/beijin/upload/tmp/20220214/a02af7fb53c4f2632a9aa17bc7a6e1802c88fa220dade0fe56eec87a14cb057a.jpeg";

    public static void main(String[] args) throws Exception {

        URL url = new URL(imageURL);
        //������
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //��������ʽΪ"GET"
        conn.setRequestMethod("GET");
        //��ʱ��Ӧʱ��Ϊ5��
        conn.setConnectTimeout(5 * 1000);


        try (OutputStream outputStream = new FileOutputStream("copyUrlImg2.png"); InputStream inputStream = conn.getInputStream()) {

            //�õ�ͼƬ�Ķ��������ݣ��Զ����Ʒ�װ�õ����ݣ�����ͨ����
            int length;
            while ((length = inputStream.read()) != -1) {
                outputStream.write(length);
                outputStream.flush();
                System.out.println(length);
            }
            System.out.println(length);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
