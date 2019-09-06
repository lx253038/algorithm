package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/9/6 18:14
 * @Description ����������������
 * 1.ʹ�� Lock���� �� Condition�� await()��signalAll() ʵ�ֵȴ����ѻ���
 */
public class ProductConsumerUseLock {
    public static void main(String[] args) {
        Clerk1 clerk1 = new Clerk1();
        Producer1 producer = new Producer1(clerk1);
        Consumer1 consumer = new Consumer1(clerk1);

        new Thread(consumer, "����������AAA����").start();
        new Thread(producer, "����������BBB����").start();
        new Thread(consumer, "����������BBB����").start();
        new Thread(producer, "����������AAA����").start();
    }
}

class Clerk1 {
    private int product = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void getPro() {//������Ʒ
        lock.lock();
        try {
            while (product >= 1) {
                System.err.println("��Ʒ����,��ֹͣ������������\n");
                condition.await();
            }
            product++;
            System.out.println(Thread.currentThread().getName() + "������Ʒ=========��ǰ��Ʒ������" + product);
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void salePro() {//������Ʒ
        lock.lock();
        try {
            while (product <= 0) {
                System.err.println("��Ʒ���Ϊ��,��ֹͣ������������");
                condition.await();
            }
            product--;
            System.out.println(Thread.currentThread().getName() + "������Ʒ===========��ǰ��Ʒ������" + product);
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

class Producer1 implements Runnable {
    private Clerk1 clerk;

    public Producer1(Clerk1 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.getPro();
        }
    }
}

class Consumer1 implements Runnable {
    private Clerk1 clerk;

    public Consumer1(Clerk1 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.salePro();
        }

    }
}