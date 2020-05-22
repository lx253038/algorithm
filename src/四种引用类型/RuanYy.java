package ������������;

import java.lang.ref.SoftReference;

/**
 * @Author LX
 * @Date 2020/5/22 14:31
 * @Description ������(��������һ�����ǿ����������һЩ������ �� ��Ҫ��java.lang.ref.SoftReference ����ʵ��)
 * ��������������һЩ�����ã������Ǳ���Ķ���
 * ���������ù����ŵĶ�����ϵͳ��Ҫ�����ڴ�����쳣֮ǰ���������Щ�����н����շ�Χ֮�в����еڶ��λ��ա�
 * �����λ��ջ���û���㹻���ڴ棬�Ż��׳��ڴ�����쳣��
 * ����ֻ�������õĶ�����˵����ϵͳ�ڴ����ʱ�����ᱻ���գ���ϵͳ�ڴ治��ʱ���Żᱻ���ա�
 */
public class RuanYy {

    public static void main(String[] args) {
        softRefMemoryEnough();
        System.out.println("------�ڴ治���õ����------");
        softRefMemoryNotEnough();


    }

    //�ڴ����ʱ
    private static void softRefMemoryEnough() {
        Object object = new Object();
        //ob1��������object
        SoftReference<Object> ob1 = new SoftReference<>(object);
        System.out.println(object);
        System.out.println(ob1.get());

        object = null;
        System.gc();
        System.out.println(object);
        //�����ò��ᱻ����
        System.out.println(ob1.get());

    }

    //�ڴ治��ʱ
    private static void softRefMemoryNotEnough() {
        Object object = new byte[1024 * 1024 * 3];
        //ob1��������object
        SoftReference<Object> ob1 = new SoftReference<>(object);
        System.out.println(object);
        System.out.println(ob1.get());

        object = null;
        //�ڴ������󳬳�JVM�ڴ棬�ȳ���ȥ�����������ٴ������������Ȼ�ڴ治��Żᱨ��
        byte[] bytes = new byte[1024 * 1024 * 2];
        System.out.println(object);
        //�����ûᱻ����
        System.out.println(ob1.get());
    }
}
