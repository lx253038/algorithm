package Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author LX
 * @Date 2019/9/7 12:23
 * @Description 线程池（提供了一个线程队列，队列中保存着所有等待状态的线程，避免了创建与销毁额外的开销，提高了响应速度）
 * 线程池的创建与关闭  启动Runnable线程和Callable实例
 * java.util.concurrent.Executor :负责线程使用和调度的根接口
 *    |--**ExecutorService  ：子接口 线程池的主要接口
 *           |--ThreadPoolExecutor :线程池的实现类
 *           |--ScheduledExectorService  子接口 ：负责线程的调度
 *                |--ScheduledThreadPoolExecutor :继承ThreadPoolExecutor  实现了ScheduledExecutorService接口
 * 工具类 Executors
 * ExecutorService   newFixedThreadPool(5):创建固定大小的线程池
 * ExecutorService   newSingleThreadExecutor():创建单个线程池 只包含一个线程
 * ExecutorService   newCachedThreadPool(): 缓存线程池，线程数量不固定，可根据需求自动更改线程数量
 * ScheduledExecutorService  newScheduledThreadPool(5) :固定大小的线程池，可延时或者定时执行任务
 *
 */

public class TestThreadPool {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        ThreadDemo demo = new ThreadDemo();
 /*        for (int i = 0; i <10 ; i++) {
            executorService.submit(demo);
        }
        executorService.shutdown();*/
        List<Future<Integer>> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(() -> {
                int sum = 0;
                for (int i1 = 0; i1 <= 100; i1++) {
                    sum += i1;
                }
                System.out.println(Thread.currentThread().getName() + "========" + sum);
                return sum;
            });
            taskList.add(future);
        }
        for (Future<Integer> future : taskList) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}

class ThreadDemo implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (i <= 100) {
            System.out.println(Thread.currentThread().getName() + "========" + i++);
        }
    }
}
