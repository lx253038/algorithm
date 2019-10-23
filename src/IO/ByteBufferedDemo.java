package IO;

import java.io.*;

/**
 * @Author LX
 * @Date 2019/10/21 20:17
 * @Description ×Ö½Ú»º³åÁ÷ BufferedInputStream BufferedOutputStream
 */
public class ByteBufferedDemo {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            FileInputStream fis = new FileInputStream("photo.png");
            FileOutputStream fos = new FileOutputStream("copy2.jpg");
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            System.out.println(bis.available() / 1024 + "kb");
            int len;
            while ((len = bis.read()) != -1) {
                bos.write(len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
