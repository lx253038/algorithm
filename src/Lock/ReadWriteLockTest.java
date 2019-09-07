package Lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author LX
 * @Date 2019/9/6 19:52
 * @Description ��д������
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                demo.setNumber((int) (Math.random() * 100));
            }, i + "��д�߳�").start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                demo.getNum();
            }, String.valueOf(i)).start();
        }

    }
}

class ReadWriteLockDemo {
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void getNum() {
        lock.readLock().lock();
        try {

            System.out.println(Thread.currentThread().getName() + "���̻߳�ȡֵΪ:" + number);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setNumber(int num) {
        lock.writeLock().lock();
        try {
            this.number = num;
            System.out.println(Thread.currentThread().getName() + "=========>����number=" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}