package IO;

import java.io.*;

/**
 * @Author LX
 * @Date 2019/10/20 13:04
 * @Description �����ı��ļ�
 * ʹ��BufferedReader��������readLine()��������ȥ��ȡ�ı���ʹ��BufferedWriter��write()д���ı�ʵ���ļ��Ŀ���
 */
public class BufferedDemo {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileReader = new FileReader("demo.txt");
            fileWriter = new FileWriter("copy_demo.txt");
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
