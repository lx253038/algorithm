package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2020/4/13 19:26
 * @Description 公平锁和非公平锁
 * lock.lock()方法遵守公平原则  公平锁：释放锁后会在队列中排序获得到锁  非公平锁：当线程释放锁后，处于非阻塞状态的线程优先获得到锁
 * lock.tryLock()方法不遵循公平性原则
 */
public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock(true);


    public void printInt(int a) {

//        lock.lock();
//        try {
//            TimeUnit.MILLISECONDS.sleep(200);
//            System.out.println(Thread.currentThread().getName() + "打印：" + a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//        lock.lock();
//        try {
//            TimeUnit.MILLISECONDS.sleep(200);
//            System.out.println(Thread.currentThread().getName() + "打印：" + a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }

        while (true) {
            if (lock.tryLock()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);

                    System.out.println(Thread.currentThread().getName() + "打印：" + a);
                    break;
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static void main(String[] args) {
        ReentrantLockDemo lockTest = new ReentrantLockDemo();

        new Thread(() -> lockTest.printInt(1), "AA").start();
        new Thread(() -> lockTest.printInt(2), "BB").start();
        new Thread(() -> lockTest.printInt(3), "CC").start();
        new Thread(() -> lockTest.printInt(4), "DD").start();
        new Thread(() -> lockTest.printInt(5), "EE").start();
        new Thread(() -> lockTest.printInt(6), "FF").start();
    }


}
