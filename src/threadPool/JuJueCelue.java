package threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2020/3/17 18:08
 * @Description 线程池的四种拒绝策略
 */
public class JuJueCelue {

    private static AtomicInteger integer = new AtomicInteger(0);

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {


        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "执行任务:" + integer.incrementAndGet());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        /* RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();  //直接抛出异常*/
        /*  RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();  //直接丢弃掉*/
        /*RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();  //丢弃队列中存留时间最长的*/

        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();  //让提交任务的线程来执行

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(), handler);
        poolExecutor.execute(runnable);
        for (int i = 0; i < 100; i++) {
            poolExecutor.execute(runnable);
        }

        poolExecutor.shutdown();
    }


}
