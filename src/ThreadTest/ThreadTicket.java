package ThreadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/10/27 15:40
 * @Description TODO
 */
public class ThreadTicket {
    private static int ticket = 100;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        if (ticket > 0) {

                            System.out.println(Thread.currentThread().getName() + "售票成功，余票为：" + --ticket);

                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }, String.valueOf(i) + "号窗口").start();
        }
    }
}
