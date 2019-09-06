package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/9/4 20:53
 * @Description 用于解决多线程安全问题的方式:
 * synchronized (隐式锁)
 * 1.同步代码块
 * 2.同步方法
 * jdk1.5以后
 * 3.同步锁Lock （是一个显示锁，须通过lock()方法上锁 然后必须通过unlock()方法进行释放锁）
 */
public class TestLock {


    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "1号窗口").start();

        new Thread(ticket, "3号窗口").start();
    }

}

class Ticket implements Runnable {
    private int tick = 10000;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (tick > 0) {
                    /*  TimeUnit.MILLISECONDS.sleep(10);*/
                    System.out.println(Thread.currentThread().getName() + "号窗口完成售票，余票剩余：" + --tick);
                    if (tick % 2 == 0) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }
}
