package countDownLatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author LX
 * @Date 2020/4/23 21:09
 * @Description ʹ��AQSʵ���Զ�����˨
 * 1.����һ��˽�е�Sync�ڲ���̳�AbstractQueuedSynchronizer
 * 2.public Sync(int count)�ṩһ�������������вι�������ͨ������AQS��setState(count);����AQS��states����
 * 3.��дAQS�����ַ�����������Ҫ��ѡ���Ƕ�ռ���ͻ��ǹ������͵ģ� boolean tryAcquire(int arg)/int tryAcquireShared(int arg)/ boolean tryReleaseShared(int arg)/boolean tryRelease(int arg)
 * 3.�����ඨ��һ��Sync����DiyLatch(int count)���ⲿ����countʵ����Sync����
 * 4.��������д�Լ����߼�����await()/latch/release()
 * ���÷���                                  ��֤����                     ��Ӧ����ֵ                         �ص�
 * sync.acquire(1);                         tryAcquire(int arg)          true/false(����)                  ��ռ �ɲο�ReentrantLock.lock()
 * sync.acquireInterruptibly(1);            tryAcquire(int arg)          true/false(����)                  ����Ӧ�жϣ�����ͬ�ϣ�
 * sync.acquireShared(1);                   tryAcquireShared(arg)        int���ͣ�С��0������               ���� �ɲο� CountDownLatch.await()
 * sync.acquireSharedInterruptibly(1);      tryAcquireShared(arg)        int���ͣ�С��0����)                ����Ӧ�жϣ�����ͬ�ϣ�
 * sync.release(1);                         tryRelease(arg)              true(�ͷ��������������߳�)/false    ��ռ�ɲο�ReentrantLock.unlock()
 * sync.releaseShared(1);                   tryReleaseShared(arg)        true(���������������߳�)/false      ���� �ɲο� CountDownLatch.countDown()
 */
public class DiyLatch {

    public static void main(String[] args) throws InterruptedException {
        //test1();  //���һ
        test2();  //һ�ȶ�
    }

    /**
     * ��������ȴ��и����ѣ��˶�Ա�ͷ���ǹ��
     *
     * @throws InterruptedException
     */
    public static void test1() throws InterruptedException {
        DiyLatch diyLatch = new DiyLatch(10);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":����");
                    diyLatch.await();
                    System.out.println(Thread.currentThread().getName() + ":ͨ��");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
//        Thread thread = new Thread(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName() + ":����");
//
//                diyLatch.await();
//                System.out.println(Thread.currentThread().getName() + ":ͨ��");
//
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + ":���ж���");
//                e.printStackTrace();
//            }
//        }, "AAA");
        // thread.start();
//        TimeUnit.MILLISECONDS.sleep(2000);

        //thread.interrupt();

        TimeUnit.MILLISECONDS.sleep(5000);
        diyLatch.latch(10);

        System.out.println(111111111);


    }

    /**
     * һ���ȶ��
     *
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        DiyLatch diyLatch = new DiyLatch(10);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + ":ͬѧ׼����ѧ==");
                diyLatch.latch(2);
                System.out.println(Thread.currentThread().getName() + ":ͬѧ�뿪����");

            }, String.valueOf(i)).start();
        }
        System.out.println("�ȴ�����ͬѧ�뿪�رս�����");
        diyLatch.await();
        System.out.println("����ͬѧ���뿪�����Թرս�����");
    }

    private final Sync sync;

    public DiyLatch() {
        sync = null;
    }

    public DiyLatch(int count) {
        this.sync = new Sync(count);
    }

    public void await() throws InterruptedException {
//        sync.acquire(1);//��ռ
//        sync.acquireInterruptibly(1);//��ռ��Ӧ�ж�
//        sync.acquireShared(1);//����
        sync.acquireSharedInterruptibly(1);//������Ӧ�ж�
    }

    public void latch(int size) {
        sync.releaseShared(size);
    }

    public int getCount() {
        return sync.getCount();
    }

    private class Sync extends AbstractQueuedSynchronizer {
        public Sync(int count) {
            setState(count);
        }


        public int getCount() {
            return getState();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            return getState() == 0;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return getState() == 0 ? 1 : -1;
        }

        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }
        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true) {
                int num = getState();
                if (num == 0) {
                    return false;
                }
                int newVal = num - arg;

                if (compareAndSetState(num, newVal)) {
//                    System.out.println(newVal);
                    return newVal == 0;
                }
            }


        }

    }
}
