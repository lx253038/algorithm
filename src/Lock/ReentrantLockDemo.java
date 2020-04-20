package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2020/4/13 19:26
 * @Description ��ƽ���ͷǹ�ƽ��
 * lock.lock()�������ع�ƽԭ��  ��ƽ�����ͷ�������ڶ����������õ���  �ǹ�ƽ�������߳��ͷ����󣬴��ڷ�����״̬���߳����Ȼ�õ���
 * lock.tryLock()��������ѭ��ƽ��ԭ��
 */
public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock(true);


    public void printInt(int a) {

//        lock.lock();
//        try {
//            TimeUnit.MILLISECONDS.sleep(200);
//            System.out.println(Thread.currentThread().getName() + "��ӡ��" + a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//        lock.lock();
//        try {
//            TimeUnit.MILLISECONDS.sleep(200);
//            System.out.println(Thread.currentThread().getName() + "��ӡ��" + a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }

        while (true) {
            if (lock.tryLock()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);

                    System.out.println(Thread.currentThread().getName() + "��ӡ��" + a);
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
