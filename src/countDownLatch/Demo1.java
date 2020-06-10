package countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/6/9 20:38
 * @Description 模拟运动员等待裁判打枪开始跑步
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":准备好了。。。");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":开始跑步。。。");
            }, "运动员" + i).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println("各就位，预备：");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(3);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(1);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("砰，枪响了，快跑。。。。。。。。");
        countDownLatch.countDown();


    }
}
