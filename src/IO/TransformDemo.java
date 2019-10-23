package IO;

import java.io.*;

/**
 * @Author LX
 * @Date 2019/10/22 18:38
 * @Description 字符流、字节流相互转换案例
 */
public class TransformDemo {
    public static void main(String[] args) throws IOException {
        //1.键盘录入数据写入到文件
 /*       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test111.txt")));*/
        //2.将文本内容输出到控制台
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test111.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));*/
        //2.将文件中内容拷贝到另一个文件中
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test111.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy_test111.txt")));

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            if ("over".equals(str)) {
                break;
            }
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedReader.close();
        bufferedWriter.close();


    }

}
