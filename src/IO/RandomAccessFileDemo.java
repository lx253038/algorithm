package IO;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author LX
 * @Date 2019/10/26 18:37
 * @Description ֧�� ��������ʡ� �ķ�ʽ���������ֱ�������ļ�������ط�������д�ļ�
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("demo.txt", "rw");
        byte[] bytes = new byte[1024];
        int len;

        accessFile.seek(6);
        StringBuilder sb = new StringBuilder();
        while ((len = accessFile.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len));
        }
        accessFile.seek(6);
        accessFile.write("123456".getBytes());
        accessFile.write(sb.toString().getBytes());
        accessFile.close();
    }
}
