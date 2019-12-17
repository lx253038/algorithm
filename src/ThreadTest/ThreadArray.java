package ThreadTest;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/11/25 20:44
 * @Description 1.有一个抽奖池, 该抽奖池中存放了奖励的金额, 该抽奖池用一个数组int[] arr = （1-100）;
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
 */
public class ThreadArray {


    public static void main(String[] args) {
        ThreadDemo1 td = new ThreadDemo1();
        new Thread(td, "抽奖箱1").start();
        new Thread(td, "抽奖箱2").start();

    }

}

class ThreadDemo1 implements Runnable {

    private Lock lock = new ReentrantLock();

    private static int[] arr;

    static {
        arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[100 - i] = i;
        }
    }

    private int length = arr.length;

    private boolean[] exist = new boolean[arr.length];

    @Override
    public void run() {
        while (length > 0) {
            lock.lock();
            try {
                int num = new Random().nextInt(arr.length);
                if (!exist[num]) {
                    System.out.println(Thread.currentThread().getName() + "抽到了金额为：" + arr[num]);
                    exist[num] = true;
                    length--;
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }
}
