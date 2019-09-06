package Lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/9/6 18:14
 * @Description 生产者消费者问题
 * 1.使用 synchronized关键字  和 wait()、notifyAll() 实现等待唤醒机制
 */
public class ProductConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(consumer, "《《消费者AAA》》").start();
        new Thread(producer, "《《生产者BBB》》").start();
        new Thread(consumer, "《《消费者BBB》》").start();
        new Thread(producer, "《《生产者AAA》》").start();
    }
}

class Clerk {
    private int product = 0;

    public synchronized void getPro() {//生产商品
        while (product >= 1) {
            System.err.println("商品已满,请停止生产。。。。\n");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println(Thread.currentThread().getName() + "生产商品=========当前商品数量：" + product);
        this.notifyAll();

    }

    public synchronized void salePro() {//卖出商品
        while (product <= 0) {
            System.err.println("商品库存为空,请停止售卖。。。。");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println(Thread.currentThread().getName() + "卖出商品===========当前商品数量：" + product);
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