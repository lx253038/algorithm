package IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author LX
 * @Date 2019/10/19 12:02
 * @Description fileReader：字符输入流
 */
public class FileReaderDemo {

    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            int len;
            fileReader = new FileReader("demo.txt");
            /* int read = fileReader.read();//一个字符一个字符读取  一次只读取一个字符，当返回-1时表示已读取完毕*/
/*            while ((len = fileReader.read()) != -1) {  //循环去读取所有字符，知道返回结果为-1（有多少字符循环多少次）
                System.out.print((char) len);
            }*/

            char[] arr = new char[16];      //将每次读取的字符放到字符数组中，
/*            int read = fileReader.read(arr);  //read返回读取字符的个数,且每次最多读取个数为数组长度
            System.out.println(new String(arr, 0, read));*/
            //由于不确定输入流的字符数，可能出现数组长度小于字符数即一次不能全部读取，
            //使用while循环全部读取
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
