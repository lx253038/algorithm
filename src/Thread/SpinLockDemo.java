package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LX
 * @date 2019-6-27 20:22
 */

//������
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock() {
        Thread thread = Thread.currentThread();
        System.out.println("=====================�߳�:" + thread.getName() + "����");
        while (!atomicReference.compareAndSet(null, thread)) {
            /*  System.out.println("�̣߳�"+thread.getName()+"    ��ȡ��ʧ�ܣ�������һ�λ�ȡ��������");*/
        }
        System.out.println("=====================�߳�:" + thread.getName() + "�ɹ���ȡ��");

    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        if (atomicReference.compareAndSet(thread, null)) {
            System.out.println("�̣߳�" + thread.getName() + " �ͷ���");
        }

    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.mylock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unlock();

        }, "AAA").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            spinLockDemo.mylock();

            spinLockDemo.unlock();

        }, "BBB").start();

    }

}
