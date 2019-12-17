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
        /* outToFile();//输出到控制台*/
        loadFromFile();//从文件中获取
        startFive();  //一个程序只能执行五次；超过五次提示次数超出不能使用
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
                System.out.println("使用次数用尽，程序退出！");
                return;
            }
            number++;
            properties.setProperty("number", number + "");
        } else {
            properties.setProperty("number", "1");
        }
        System.out.println("第" + properties.getProperty("number") + "次使用！");
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
        //获取系统属性信息
        /* properties=System.getProperties();*/

/*        Set<String> strings = properties.stringPropertyNames();//获取所有键集
        for(String s:strings){
            System.out.println(s+"="+properties.getProperty(s));
        }*/

        properties.list(System.out);  //输出到控制台

        properties.list(new PrintStream("aaa.txt"));//输出到文件

        properties.store(new FileWriter("bb.txt"), "name/age");//持久化到文件
    }
}
