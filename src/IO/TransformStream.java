package IO;

import java.io.*;

/**
 * @Author LX
 * @Date 2019/10/21 20:27
 * @Description TODO
 */
public class TransformStream {

    public static void main(String[] args) throws IOException {
        demo1();
    }


    /**
     * �ֽ���ת�ַ���  InputStreamReader
     * �ַ���ת�ֽ���  OutputStreamWriter
     *
     * @throws IOException
     */
    private static void demo1() throws IOException {
        FileInputStream inputStream = new FileInputStream("demo.txt"); //�ֽ���

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream); //�ֽ���ת�����ַ�������

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);   //�����ַ���������
        String res;
        StringBuilder builder = new StringBuilder();
        while ((res = bufferedReader.readLine()) != null) {
            builder.append(res);
            builder.append(System.getProperty("line.separator"));
        }

        FileOutputStream outputStream = new FileOutputStream("CopyTransformStream.txt");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(builder.toString());
        bufferedWriter.flush();

        inputStream.close();
        outputStream.close();

        bufferedReader.close();
        bufferedWriter.close();

    }


}
