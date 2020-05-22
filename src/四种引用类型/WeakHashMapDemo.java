package ������������;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @Author LX
 * @Date 2020/5/22 14:56
 * @Description WeakHashMap����Ӧ��WeakHashMap��HashMap������
 */
public class WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===============HashMapִ�н��===============");
        myHashMap();
        System.out.println("===============WeakHashMapִ�н��===============");
        myWeakHashMap();
    }

    public static void myHashMap() {
        HashMap<String, String> map = new HashMap<>();
        String key = new String("k1");
        String value = "v1";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();

        System.out.println(map);
    }

    public static void myWeakHashMap() {
        WeakHashMap<String, String> map = new WeakHashMap<>();
        //String key = "weak";
        // �տ�ʼд�����ϱߵĴ���
        //˼��һ�£�д���ϱ���������ô���� �ǿɲ���������
        String key = new String("weak");
        String value = "map";
        map.put(key, value);
        System.out.println(map);
        //ȥ��ǿ����
        key = null;
        System.gc();

        System.out.println(map);
    }
}

