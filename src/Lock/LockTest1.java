package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lixin
 * @date: 2022/8/26 09:20
 * @description:
 */
public class LockTest1 {


    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(() -> {
            try {

                lock.lock();
                try {
                    System.out.println("currThread:" + Thread.currentThread());
                } finally {
                    lock.unlock();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "thread1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                lock.lock();
                try {
                    System.out.println("currThread:" + Thread.currentThread());
                } finally {
                    lock.unlock();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "thread2");
        thread2.start();

        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("currThread:" + Thread.currentThread());
                    } finally {
                        lock.unlock();
                    }

                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "thread3");
        thread3.start();
        System.out.println("main end...");


    }


}
