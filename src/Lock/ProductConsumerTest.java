package Lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/9/6 18:14
 * @Description ����������������
 * 1.ʹ�� synchronized�ؼ���  �� wait()��notifyAll() ʵ�ֵȴ����ѻ���
 */
public class ProductConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(consumer, "����������AAA����").start();
        new Thread(producer, "����������BBB����").start();
        new Thread(consumer, "����������BBB����").start();
        new Thread(producer, "����������AAA����").start();
    }
}

class Clerk {
    private int product = 0;

    public synchronized void getPro() {//������Ʒ
        while (product >= 1) {
            System.err.println("��Ʒ����,��ֹͣ������������\n");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println(Thread.currentThread().getName() + "������Ʒ=========��ǰ��Ʒ������" + product);
        this.notifyAll();

    }

    public synchronized void salePro() {//������Ʒ
        while (product <= 0) {
            System.err.println("��Ʒ���Ϊ��,��ֹͣ������������");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println(Thread.currentThread().getName() + "������Ʒ===========��ǰ��Ʒ������" + product);
        this.notifyAll();

    }

}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
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

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
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