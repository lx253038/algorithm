package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LX
 * @date 2019-7-3 18:39
 * 循环栅栏  允许一组线程互相等待，直到所有线程都到达某个公共屏障点
 * parties：设置参与的线程个数，调用await()方法屏障等待，直到达到屏障的数量等于parties时，所有的线程才会继续执行下去。
 */

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println(Thread.currentThread().getName() + "集齐七颗龙珠，释放神龙！"));

        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "获得一颗龙珠！");
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
