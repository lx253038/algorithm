package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author LX
 * @Date 2019/9/4 20:42
 * @Description ʹ��Callable����ִ���߳� �����շ���ֵ
 */
public class TestCallable {

    public static void main(String[] args) {
        ThredDemo thredDemo = new ThredDemo();
        FutureTask<Integer> task = new FutureTask<>(thredDemo);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("==========�߳�ִ����==============");
        try {
            System.out.println(task.get());   //FutureTask �����ڱ���
            System.out.println("==========�߳�ִ�����==============");


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