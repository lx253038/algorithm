package IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author LX
 * @Date 2019/10/20 14:55
 * @Description TODO
 */
public class MyBufferDemoTest {

    public static void main(String[] args) {
        FileReader fileReader = null;
        MyReaderBuffer buffer = null;
        try {
            fileReader = new FileReader("demo.txt");
            buffer = new MyReaderBuffer(fileReader);
            String res;
            while ((res = buffer.myReadLine()) != null) {
                System.out.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
