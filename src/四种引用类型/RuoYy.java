package ������������;

import java.lang.ref.WeakReference;

/**
 * @Author LX
 * @Date 2020/5/22 14:51
 * @Description �����ã���������Ҫ��java.lang.ref.WeakReference����ʵ�֣����������õ������ڸ��̣�
 * �������ù����Ķ���ֻ�����浽��һ�������ռ�����֮ǰ���������ռ�������ʱ�����۵�ǰ�ڴ��Ƿ��㹻��������յ�ֻ�������ù����Ķ���
 * ����ֻ�������õĶ�����˵��ֻҪ�������ջ���һ���У����� JVM ���ڴ�ռ��Ƿ��㹻��������ոö���ռ�õ��ڴ档
 */
public class RuoYy {

    public static void main(String[] args) {
        Object object = new Object();
        //ob1��������object
        WeakReference<Object> ob1 = new WeakReference<>(object);
        System.out.println(object);
        System.out.println(ob1.get());

        object = null;
        //ִ���������գ�������ֱ��Ҳ�ᱻ���յ�
        System.gc();

        System.out.println(object);
        System.out.println(ob1.get());

    }
}
