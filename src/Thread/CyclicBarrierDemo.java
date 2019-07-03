package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LX
 * @date 2019-7-3 18:39
 * ѭ��դ��  ����һ���̻߳���ȴ���ֱ�������̶߳�����ĳ���������ϵ�
 * parties�����ò�����̸߳���������await()�������ϵȴ���ֱ���ﵽ���ϵ���������partiesʱ�����е��̲߳Ż����ִ����ȥ��
 */

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println(Thread.currentThread().getName() + "�����߿����飬�ͷ�������"));

        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "���һ�����飡");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }


    }


}
