package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: lixin
 * @date: 2022/2/16 5:22 下午
 * @description:
 */
public class UrlImageCopy {

    public static final String imageURL = "https://img.bosszhipin.com/beijin/upload/tmp/20220214/a02af7fb53c4f2632a9aa17bc7a6e1802c88fa220dade0fe56eec87a14cb057a.jpeg";

    public static void main(String[] args) throws Exception {

        URL url = new URL(imageURL);
        //打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置请求方式为"GET"
        conn.setRequestMethod("GET");
        //超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);


        try (OutputStream outputStream = new FileOutputStream("copyUrlImg2.png"); InputStream inputStream = conn.getInputStream()) {

            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
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
