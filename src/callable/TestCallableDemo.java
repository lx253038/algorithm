package callable;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/9/4 20:42
 * @Description 使用Callable创建执行线程 并接收返回值
 */
public class TestCallableDemo {

    public static void main(String[] args) {
//        ThreadDemo threadDemo = new ThreadDemo();
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0; i <= 100000; i++) {
                sum += i;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("中断异常，任务被取消了====");
            }
            return sum;
        });
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("==========线程执行中==============");
        try {
            System.out.println(task.get(1000, TimeUnit.MILLISECONDS));   //FutureTask 可用于闭锁
        } catch (Exception e) {
            System.out.println("超时异常，规定时间内未获取到结果，取消任务");

            System.out.println("任务取消是否成功：" + task.cancel(true));

            System.out.println("任务是否完成：" + task.isDone());  //任务是否完成
            try {
                System.out.println(task.get());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("任务是否完成：" + task.isDone());  //任务是否完成

            System.out.println("任务完成时，取消是否成功：" + task.cancel(true));

        }
        System.out.println("==========线程执行完毕==============");
    }
}

//class ThreadDemo implements Callable<Integer> {
//
//    @Override
//    public Integer call() throws Exception {
//        int sum = 0;
//        for (int i = 0; i <= 100000; i++) {
//            sum += i;
//        }
//        TimeUnit.MILLISECONDS.sleep(2000);
//        return sum;
//    }
//}