package semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/6/9 21:11
 * @Description 模拟十家单位获取到许可证才能开始干活
 * semaphore.acquire(x) 获取x个许可证，默认为1个，未获取到许可证将会阻塞知道获取后才能执行
 * semaphore.release(x) 释放x个许可证，默认1个，此方法写到finally代码块中，避免因为异常导致无法释放导致死锁
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(6);

        //1.acquire(10)方法获取许可证的数量不能大于设置的数量，否则会造成死锁
        //2.release(10)方法释放许可证的数量不能大于获取的数量，会造成许可证总数量增多
        //3.release(2)方法释放许可证的数量不能小于获取的数量，可能会造成死锁（尽量获取几个释放几个）
//        new Thread(() -> {
//            try {
//                semaphore.acquire(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                semaphore.release(6);
//            }
//        }, "AAA").start();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(2);
                    System.out.println(Thread.currentThread().getName() + "：获取到许可证,开始干活。。。。。。");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(2);
                    System.out.println(Thread.currentThread().getName() + "：释放许可证。。。。。。。。");

                }
            }, "线程" + i).start();
        }

    }
}
