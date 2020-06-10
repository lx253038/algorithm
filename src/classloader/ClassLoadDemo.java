package classloader;

/**
 * @Author LX
 * @Date 2020/6/6 14:08
 * @Description 类加载器
 * BootStrapClassLoader:C++编写，加载核心类库 java.*
 * ExtClassLoader:java编写，加载扩张类库 javax.*
 * AppClassLoader:java编写，加载classpath下的class文件
 * CustomClassLoader：用户自定义类加载器，加载指定目录下的class文件
 * |---继承ClassLoader类，重写findClass(String name)方法,返回defineClass(name, byteArray, 0, byteArray.length)类对象
 * 双亲委派机制：自底向上检查类是否已经被加载（已经被加载过就直接使用，否则向上检查是否被加载），自顶向下尝试加载类（存在对应的class就加载，否则由下一类型的加载器去加载）
 */
public class ClassLoadDemo {
    public static void main(String[] args) throws Exception {

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> loadClass = myClassLoader.loadClass("AlliceDemo");
        System.out.println(loadClass.getClassLoader());
        System.out.println(loadClass.getClassLoader().getParent());
        System.out.println(loadClass.getClassLoader().getParent().getParent());
        System.out.println(loadClass.getClassLoader().getParent().getParent().getParent());
        loadClass.newInstance();
    }
}
