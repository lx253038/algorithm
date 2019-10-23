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
     * 字节流转字符流  InputStreamReader
     * 字符流转字节流  OutputStreamWriter
     *
     * @throws IOException
     */
    private static void demo1() throws IOException {
        FileInputStream inputStream = new FileInputStream("demo.txt"); //字节流

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream); //字节流转换成字符流对象

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);   //创建字符流缓冲区
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
