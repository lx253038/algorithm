package mianjing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/7/21 19:45
 * @Description 提交到线程池中的任务抛异常会怎么样
 */
public class ThreadPoolEx {

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 600, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futureList.add(poolExecutor.submit(task));
        }
        for (Future task1 : futureList) {
            task1.get();
        }
        while (!poolExecutor.isTerminated()) {
            System.out.println(poolExecutor.getActiveCount());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "====");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(1111);
        //发生运行时异常
        if (new Random().nextInt(10) >= 8) {
            System.out.println(1 / 0);

        }
    }
}
