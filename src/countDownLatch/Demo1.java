package countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/6/9 20:38
 * @Description ģ���˶�Ա�ȴ����д�ǹ��ʼ�ܲ�
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":׼�����ˡ�����");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":��ʼ�ܲ�������");
            }, "�˶�Ա" + i).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println("����λ��Ԥ����");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(3);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(1);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("�飬ǹ���ˣ����ܡ���������������");
        countDownLatch.countDown();


    }
}
