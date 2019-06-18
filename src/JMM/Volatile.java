package JMM;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LX
 * Volatile�ڴ�ģ��
 * @date 2019-6-11 18:46
 */
class MyData {
    volatile int num = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addNumTo60() {
        this.num = 60;
    }

    public void addNumPlus() {
        this.num++;
    }
}


public class Volatile {


    //��֤�ɼ���
    @Test
    public void kejianxing() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addNumTo60();
            System.out.println(Thread.currentThread().getName() + "  update num :" + myData.num);
        }, "AAA").start();
        System.out.println(Thread.currentThread().getName() + "  update num111111111111111111 :" + myData.num);
        while (myData.num == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "  update num :" + myData.num);
    }

    //��������ǵ��� 50*1000=50000  ���Բ��߱�ԭ����(���豣֤ԭ��������Ҫ�ڷ���ǰ���synchronized����)
    @Test
    public void yuanzixing() {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addNumPlus();
                    myData.atomicInteger.getAndIncrement();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("�����numֵΪ��" + myData.num);
        System.out.println("�����atomicIntegerֵΪ��" + myData.atomicInteger);
    }
}
