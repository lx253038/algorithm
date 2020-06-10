package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author LX
 * @date 2019-7-3 20:21
 * Semaphore信号量(许可证) 用来控制同时访问某个特定资源的操作数量，或者同时执行某个指定操作的数量
 * 例：10辆车看成10个线程，抢占 3个车位（即Semaphore设置数量等于3）;
 * 调用acquire()方法抢占资源，未抢到的则等待，release()释放资源
 */

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "号抢到车位！");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "号停三秒，释放车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }


            }, String.valueOf(i)).start();
        }


    }
}
