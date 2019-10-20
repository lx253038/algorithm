package IO;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author LX
 * @Date 2019/10/20 14:40
 * @Description �Լ���дʵ��BufferedReader������
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
     * ÿ�ζ�ȡһ���ַ���ͨ���ж�count�Ƿ�ӻ�������ȡ
     *
     * @return
     * @throws IOException
     */
    private int myRead() throws IOException {
        if (count == 0) { //count==0 ������char[]������û�����ݣ�ͨ��read(char[])������ȡ���ݵ�������
            pos = 0;
            count = reader.read(ch);
        }
        if (count < 0) { //�������ݶ�ȡ���
            return -1;
        }
        count--;    //ÿ�ζ�ȡcount-1��֪��count=0����������ȡ

        return ch[pos++]; //pos�ö�ȡ�����������еĽǱ꣬ÿ�ζ�ȡ����1
    }

    /**
     * ���ж�ȡ
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
