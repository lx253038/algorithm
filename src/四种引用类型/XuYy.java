package ������������;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author LX
 * @Date 2020/5/22 15:04
 * @Description ������(��������Ҫjava.lang.ref.PhantomReference ��ʵ�� ��)
 * �����ܵ���ʹ��Ҳ����ͨ�������ʶ��������ñ�������ö��У�RefenenceQueue������ʹ�á�
 * ���������õ�ΨһĿ�ģ�������������󱻻��������յ�ʱ���յ�һ��ϵͳ֪ͨ���ߺ�����ӽ�һ���Ĵ���
 */
public class XuYy {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(phantomReference.get());

        o1 = null;
        System.gc();
        System.out.println("ִ����������");
        Thread.sleep(3000);

        System.out.println(o1);
        System.out.println(referenceQueue.poll()); //���ö�����
        System.out.println(phantomReference.get());
    }

}
