package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/9/4 20:53
 * @Description ���ڽ�����̰߳�ȫ����ķ�ʽ:
 * synchronized (��ʽ��)
 * 1.ͬ�������
 * 2.ͬ������
 * jdk1.5�Ժ�
 * 3.ͬ����Lock ����һ����ʾ������ͨ��lock()�������� Ȼ�����ͨ��unlock()���������ͷ�����
 */
public class TestLock {


    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(ticket, "2�Ŵ���").start();
        new Thread(ticket, "1�Ŵ���").start();

        new Thread(ticket, "3�Ŵ���").start();
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
                    System.out.println(Thread.currentThread().getName() + "�Ŵ��������Ʊ����Ʊʣ�ࣺ" + --tick);
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
