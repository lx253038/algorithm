package cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/6/9 20:48
 * @Description �Ž��ȴ����е����˲ų���
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println(Thread.currentThread().getName() + ":666666666666666666666"));
        cyclicBarrier.getParties();
        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + ":���ˡ�����");
                    cyclicBarrier.await();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "������ˣ�ˡ���������");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "�˶�Ա" + i).start();
        }
        System.out.println("�ȴ������˶����˲ų���");
        cyclicBarrier.await();
        System.out.println("�����˵����ˣ�������������������");

    }
}
