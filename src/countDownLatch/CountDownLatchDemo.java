package countDownLatch;

import java.util.concurrent.CountDownLatch;

import Enum.SixKing;

/**
 * @author LX
 * @date 2019-7-3 17:50
 * ����ʱ��
 */
//���õ���ʱ��ʼֵ������countDown()������1��ʹ��await()�����̵߳ȴ�����ʱΪ0����ִ��
public class CountDownLatchDemo {

    private static CountDownLatch count = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "��ͬѧ�뿪��");
                count.countDown();
            }, SixKing.findById(String.valueOf(i)).getName()).start();
        }
        count.await();
        System.out.println(Thread.currentThread().getName() + "�رս�����");
    }

}
