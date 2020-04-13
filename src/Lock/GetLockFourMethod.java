package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2020/3/23 20:15
 * @Description Lock中获取锁的四个方法
 * lock() tryLock()  tryLock(long time, TimeUnit unit)   lockInterruptibly()
 */
public class GetLockFourMethod {

    public static void main(String[] args) throws InterruptedException {
        RunableTest runableTest = new RunableTest();
        Thread t1 = new Thread(runableTest, "线程1");
        Thread t2 = new Thread(runableTest, "线程2");
        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(1);

        t2.interrupt();

    }

}

class RunableTest implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":尝试获得锁");
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + ":获得锁");
                TimeUnit.SECONDS.sleep(5);

            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + ":睡眠中断");
            } finally {
                System.out.println(Thread.currentThread().getName() + ":释放锁");

                lock.unlock();
            }


        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + ":等待中断");
        }

    }
}
