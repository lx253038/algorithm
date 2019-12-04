package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/9/6 19:23
 * @Description 开启三个线程，这三个线程的Id分别为A B C，每个线程将自己的ID打印在控制台上10遍  并按照ABCABCABC.... 依次递归
 */
public class ABCIternate {
    public static void main(String[] args) {
        Iternate iternate = new Iternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    iternate.loopA();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    iternate.loopB();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    iternate.loopC();
                }
            }
        }, "C").start();
    }
}

class Iternate {
    private volatile int num = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            System.out.print(Thread.currentThread().getName());
            num = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.print(Thread.currentThread().getName());
            num = 3;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            System.out.print(Thread.currentThread().getName());
            num = 1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
