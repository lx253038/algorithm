package Lock;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/9/7 12:23
 * @Description 线程池
 * ScheduledExecutorService 线程调度 可以延时或者定时执行任务
 */

public class TestSchecduledThreadPool {
    public static void main(String[] args) throws Exception {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.schedule(() -> {
                int num = new Random().nextInt(100);
                System.out.println(Thread.currentThread().getName() + "========" + num);
                return num;
            }, 1, TimeUnit.SECONDS);
            System.out.println(future.get());
        }

        pool.shutdown();
    }
}


