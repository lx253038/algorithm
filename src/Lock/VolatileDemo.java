package Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LX
 * @Date 2019/10/29 19:58
 * @Description ��֤volatile���ڴ�ɼ���
 */
public class VolatileDemo {

    public static volatile int number = 0;

    //ԭ�����ͣ�����ԭ���ԣ�
    public static AtomicInteger integer = new AtomicInteger(0);

    public static void addNumber() {
        number++;
        integer.getAndIncrement();
    }

    public static void main(String[] args) {
        //��֤�ɼ���
/*        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 60;
            System.out.println(Thread.currentThread().getName() + "�߳��޸���number��ֵ��number=" + number);

        }, "AAA").start();
        //����volatile ����number�����߳�AAA�޸�number�� main�߳��޷���ȡ���º��ֵ �����ڴ�һֱѭ��
        //��ʹ��volatile���߳�AAA �޸ĺ� main�߳�������ȡ���˱��޸ĺ��ֵ �ɴ���֤��volatile���ڴ�ɼ���
        while (number == 0) {
        }
        System.out.println(Thread.currentThread().getName() + "�߳�,number=" + number);*/
        //��֤������ԭ����
        //����10���߳� ѭ��1000��number++;����״̬�� ���numberӦ�õ���10000��  ʵ�ʽ������С��10000 ���Բ�����ԭ����
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                for (int j = 0; j < 1000; j++) {
                    addNumber();
                }
            }, i + "").start();
        }
        while (Thread.activeCount() > 2) {

            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "�߳�(��ͨ���ͣ����߱�ԭ����)��number��" + number);
        System.out.println(Thread.currentThread().getName() + "�߳�(ԭ�����ͣ�����ԭ����)��integer��" + integer);

    }


}


