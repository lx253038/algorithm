package classloader;

/**
 * @Author LX
 * @Date 2020/6/6 14:08
 * @Description �������
 * BootStrapClassLoader:C++��д�����غ������ java.*
 * ExtClassLoader:java��д������������� javax.*
 * AppClassLoader:java��д������classpath�µ�class�ļ�
 * CustomClassLoader���û��Զ����������������ָ��Ŀ¼�µ�class�ļ�
 * |---�̳�ClassLoader�࣬��дfindClass(String name)����,����defineClass(name, byteArray, 0, byteArray.length)�����
 * ˫��ί�ɻ��ƣ��Ե����ϼ�����Ƿ��Ѿ������أ��Ѿ������ع���ֱ��ʹ�ã��������ϼ���Ƿ񱻼��أ����Զ����³��Լ����ࣨ���ڶ�Ӧ��class�ͼ��أ���������һ���͵ļ�����ȥ���أ�
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
