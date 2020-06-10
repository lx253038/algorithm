package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author LX
 * @Date 2020/6/6 13:25
 * @Description
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) {

        byte[] byteArray = getByteArray(name);
        return defineClass(name, byteArray, 0, byteArray.length);
    }

    private byte[] getByteArray(String name) {
        File file = new File("E:\\IntelliJ\\algorithm\\src\\classloader\\" + name + ".class");
        FileInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(file);
            outputStream = new ByteArrayOutputStream();
            int len;
            while ((len = inputStream.read()) != -1) {
                outputStream.write(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream.toByteArray();

    }


}
