package IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author LX
 * @Date 2019/10/19 12:02
 * @Description FileWriter 字符输出流
 */
public class FileWriterDemo {


    private static final String LINE_FEED = System.getProperty("line.separator"); //获取系统换行

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("demo.txt", true);   //append 是否在原有内容上进行拼接
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
