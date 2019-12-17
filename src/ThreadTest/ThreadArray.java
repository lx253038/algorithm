package ThreadTest;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/11/25 20:44
 * @Description 1.��һ���齱��, �ó齱���д���˽����Ľ��, �ó齱����һ������int[] arr = ��1-100��;
 * ���������齱��(�߳�)�����߳����Ʒֱ�Ϊ���齱��1�������齱��2���������arr�����л�ȡ����Ԫ�ز���ӡ�ڿ���̨��,��ʽ����:
 */
public class ThreadArray {


    public static void main(String[] args) {
        ThreadDemo1 td = new ThreadDemo1();
        new Thread(td, "�齱��1").start();
        new Thread(td, "�齱��2").start();

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
                    System.out.println(Thread.currentThread().getName() + "�鵽�˽��Ϊ��" + arr[num]);
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
