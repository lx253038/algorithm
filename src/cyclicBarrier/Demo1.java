package cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/6/9 20:48
 * @Description 团建等待所有到齐了才出发
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println(Thread.currentThread().getName() + ":666666666666666666666"));
        cyclicBarrier.getParties();
        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + ":到了。。。");
                    cyclicBarrier.await();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "可以玩耍了。。。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "运动员" + i).start();
        }
        System.out.println("等待所有人都到了才出发");
        cyclicBarrier.await();
        System.out.println("所有人到齐了，出发。。。。。。。");

    }
}
