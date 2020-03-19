package threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2020/3/17 18:08
 * @Description �̳߳ص����־ܾ�����
 */
public class JuJueCelue {

    private static AtomicInteger integer = new AtomicInteger(0);

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {


        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "ִ������:" + integer.incrementAndGet());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        /* RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();  //ֱ���׳��쳣*/
        /*  RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();  //ֱ�Ӷ�����*/
        /*RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();  //���������д���ʱ�����*/

        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();  //���ύ������߳���ִ��

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(), handler);
        poolExecutor.execute(runnable);
        for (int i = 0; i < 100; i++) {
            poolExecutor.execute(runnable);
        }

        poolExecutor.shutdown();
    }


}
