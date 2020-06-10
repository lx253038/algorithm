package countDownLatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author LX
 * @Date 2020/4/23 21:09
 * @Description 使用AQS实现自定义门栓
 * 1.定义一个私有的Sync内部类继承AbstractQueuedSynchronizer
 * 2.public Sync(int count)提供一个传入数量的有参构造器，通过调用AQS的setState(count);设置AQS中states数量
 * 3.重写AQS这四种方法（根据需要，选择是独占类型还是共享类型的） boolean tryAcquire(int arg)/int tryAcquireShared(int arg)/ boolean tryReleaseShared(int arg)/boolean tryRelease(int arg)
 * 3.工具类定义一个Sync对象，DiyLatch(int count)，外部传入count实例化Sync对象
 * 4.工具类中写自己的逻辑方法await()/latch/release()
 * 调用方法                                  验证方法                     对应返回值                         特点
 * sync.acquire(1);                         tryAcquire(int arg)          true/false(阻塞)                  独占 可参考ReentrantLock.lock()
 * sync.acquireInterruptibly(1);            tryAcquire(int arg)          true/false(阻塞)                  可响应中断（其他同上）
 * sync.acquireShared(1);                   tryAcquireShared(arg)        int类型（小于0阻塞）               共享 可参考 CountDownLatch.await()
 * sync.acquireSharedInterruptibly(1);      tryAcquireShared(arg)        int类型（小于0阻塞)                可响应中断（其他同上）
 * sync.release(1);                         tryRelease(arg)              true(释放锁，唤醒其他线程)/false    独占可参考ReentrantLock.unlock()
 * sync.releaseShared(1);                   tryReleaseShared(arg)        true(唤醒所有阻塞的线程)/false      共享 可参考 CountDownLatch.countDown()
 */
public class DiyLatch {

    public static void main(String[] args) throws InterruptedException {
        //test1();  //多等一
        test2();  //一等多
    }

    /**
     * 多个阻塞等待有个唤醒（运动员和发令枪）
     *
     * @throws InterruptedException
     */
    public static void test1() throws InterruptedException {
        DiyLatch diyLatch = new DiyLatch(10);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":阻塞");
                    diyLatch.await();
                    System.out.println(Thread.currentThread().getName() + ":通行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
//        Thread thread = new Thread(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName() + ":阻塞");
//
//                diyLatch.await();
//                System.out.println(Thread.currentThread().getName() + ":通行");
//
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + ":被中断了");
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
     * 一个等多个
     *
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        DiyLatch diyLatch = new DiyLatch(10);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + ":同学准备放学==");
                diyLatch.latch(2);
                System.out.println(Thread.currentThread().getName() + ":同学离开教室");

            }, String.valueOf(i)).start();
        }
        System.out.println("等待所有同学离开关闭教室门");
        diyLatch.await();
        System.out.println("所有同学已离开，可以关闭教室门");
    }

    private final Sync sync;

    public DiyLatch() {
        sync = null;
    }

    public DiyLatch(int count) {
        this.sync = new Sync(count);
    }

    public void await() throws InterruptedException {
//        sync.acquire(1);//独占
//        sync.acquireInterruptibly(1);//独占响应中断
//        sync.acquireShared(1);//共享
        sync.acquireSharedInterruptibly(1);//共享响应中断
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
