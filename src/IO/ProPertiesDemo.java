package IO;

import java.io.*;
import java.util.Properties;

/**
 * @Author LX
 * @Date 2019/10/24 18:20
 * @Description TODO
 */
public class ProPertiesDemo {
    public static void main(String[] args) throws IOException {
        /* outToFile();//���������̨*/
        loadFromFile();//���ļ��л�ȡ
        startFive();  //һ������ֻ��ִ����Σ����������ʾ������������ʹ��
    }

    private static void startFive() throws IOException {
        Properties properties = new Properties();
        File file = new File("count.properties");
        if (!file.exists()) {
            file.createNewFile();
        }
        properties.load(new FileInputStream("count.properties"));
        if (properties.containsKey("number")) {
            Integer number = Integer.valueOf(properties.getProperty("number"));
            if (number >= 5) {
                System.out.println("ʹ�ô����þ��������˳���");
                return;
            }
            number++;
            properties.setProperty("number", number + "");
        } else {
            properties.setProperty("number", "1");
        }
        System.out.println("��" + properties.getProperty("number") + "��ʹ�ã�");
        properties.store(new FileWriter("count.properties"), "");


    }

    private static void loadFromFile() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("bb.txt"));

        properties.list(System.out);

    }

    private static void outToFile() throws IOException {
        Properties properties = new Properties();
        properties.put("name", "zhangsan");
        properties.put("age", "22");
        properties.put("sex", "1");
        properties.put("1111", "222");
        //��ȡϵͳ������Ϣ
        /* properties=System.getProperties();*/

/*        Set<String> strings = properties.stringPropertyNames();//��ȡ���м���
        for(String s:strings){
            System.out.println(s+"="+properties.getProperty(s));
        }*/

        properties.list(System.out);  //���������̨

        properties.list(new PrintStream("aaa.txt"));//������ļ�

        properties.store(new FileWriter("bb.txt"), "name/age");//�־û����ļ�
    }
}
