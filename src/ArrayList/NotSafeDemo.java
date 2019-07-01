package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LX
 * @date 2019-6-26 18:08
 */

public class NotSafeDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //ArrayList �̲߳���ȫ  �ᱨjava.util.ConcurrentModificationException  �������޸Ĵ���
        //����ԭ�򣺲��������޸ĵ��£�һ���߳�����д�룬��һ���̹߳���������Դ�������ݲ�һ���쳣�������޸��쳣
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 6));
                /*  System.out.println(list);*/
            }, String.valueOf(i)).start();
        }
        //�������
        //1.ʹ���̰߳�ȫ��Vector( public synchronized boolean add(E e) ʹ��synchronized�����̰߳�ȫ��������Ч�ʽ���)
/*        Vector<String> vector = new Vector<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                vector.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(vector + ":" + Thread.currentThread().getName());
            }, String.valueOf(i)).start();
        }*/
        //2.����Collections���synchronizedList��������һ���̰߳�ȫ��list
/*        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                list2.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(list2);
            }, String.valueOf(i)).start();
        }*/
        //3.new һ��CopyOnWriteArrayList��ʹ��CopyOnWrite��дʱ���ơ���д�����˼��
        List<String> list3 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                list3.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(list3);
            }, String.valueOf(i)).start();
        }
        ;
    }

}
