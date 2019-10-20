package IO;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author LX
 * @Date 2019/10/20 14:40
 * @Description 自己手写实现BufferedReader缓冲流
 */
public class MyReaderBuffer extends Reader {

    private Reader reader;

    private char[] ch = new char[1024];

    public MyReaderBuffer(Reader reader) {
        this.reader = reader;
    }

    private int count = 0;
    private int pos = 0;

    /**
     * 每次读取一个字符，通过判断count是否从缓冲区读取
     *
     * @return
     * @throws IOException
     */
    private int myRead() throws IOException {
        if (count == 0) { //count==0 缓冲区char[]数组中没有数据，通过read(char[])批量读取数据到缓冲区
            pos = 0;
            count = reader.read(ch);
        }
        if (count < 0) { //所有数据读取完毕
            return -1;
        }
        count--;    //每次读取count-1，知道count=0重新批量读取

        return ch[pos++]; //pos该读取数据在数组中的角标，每次读取自增1
    }

    /**
     * 按行读取
     *
     * @return
     * @throws IOException
     */
    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int res;
        while ((res = myRead()) != -1) {

            if (res == '\r' && myRead() == '\n') {
                return sb.toString();
            }
            sb.append((char) res);
        }

        return sb.length() > 0 ? sb.toString() : null;
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return reader.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
