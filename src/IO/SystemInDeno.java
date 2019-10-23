package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author LX
 * @Date 2019/10/21 21:08
 * @Description 模拟从键盘输入字符并获取
 */
public class SystemInDeno {

    public static void main(String[] args) throws IOException {
        //demo1();
        demo2();
    }

    private static void demo2() throws IOException {
        InputStream inputStream = System.in;  //获取键盘输入流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);  //创建字节转换成字符流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  //创建字符缓冲
        String str;
        while ((str = bufferedReader.readLine()) != null) {   //通过字符缓冲流readLine()按行读取
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
            System.out.println(read);  //无法结束，每次都将回车换行读取出来
        }

    }

}
