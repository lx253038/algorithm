package countDownLatch;

import java.util.concurrent.CountDownLatch;

import Enum.SixKing;

/**
 * @author LX
 * @date 2019-7-3 17:50
 * 倒计时器
 */
//设置倒计时初始值，调用countDown()方法减1，使用await()阻塞线程等待倒计时为0方可执行
public class CountDownLatchDemo {

    private static CountDownLatch count = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号同学离开！");
                count.countDown();
            }, SixKing.findById(String.valueOf(i)).getName()).start();
        }
        count.await();
        System.out.println(Thread.currentThread().getName() + "关闭教室门");
    }

}
