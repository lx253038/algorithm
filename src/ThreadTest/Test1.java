package ThreadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LX
 * @Date 2019/11/26 11:03
 * @Description TODO
 */
public class Test1 {
    private static AtomicInteger sum = new AtomicInteger(0);

    private static CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) {

        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                for (int i = 1; i <= 100; i++) {

                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*  sum += i;*/

                    System.out.println(Thread.currentThread().getName() + ":sum=" + sum.getAndAdd(i));
                }
                latch.countDown();
            }, "AAAA---" + j).start();
        }

/*
        new Thread(() -> {
            for (int i = 101; i <= 200; i++) {
                sum += i;
                System.out.println(Thread.currentThread().getName() + ":sum=" + sum);

            }
            latch.countDown();
        }, "BBBB").start();
*/

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("×ÜºÍsum=" + sum);
        int sum1 = 0;
        for (int i = 0; i <= 10; i++) {
            sum1 += i;
        }
        System.out.println(sum1);
    }
}
