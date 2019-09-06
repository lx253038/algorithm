package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author LX
 * @Date 2019/9/4 20:42
 * @Description 使用Callable创建执行线程 并接收返回值
 */
public class TestCallable {

    public static void main(String[] args) {
        ThredDemo thredDemo = new ThredDemo();
        FutureTask<Integer> task = new FutureTask<>(thredDemo);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("==========线程执行中==============");
        try {
            System.out.println(task.get());   //FutureTask 可用于闭锁
            System.out.println("==========线程执行完毕==============");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThredDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100000000; i++) {
            sum += i;
        }
        return sum;
    }
}