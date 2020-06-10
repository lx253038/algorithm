package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author LX
 * @date 2019-7-3 20:21
 * Semaphore�ź���(���֤) ��������ͬʱ����ĳ���ض���Դ�Ĳ�������������ͬʱִ��ĳ��ָ������������
 * ����10��������10���̣߳���ռ 3����λ����Semaphore������������3��;
 * ����acquire()������ռ��Դ��δ��������ȴ���release()�ͷ���Դ
 */

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "��������λ��");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "��ͣ���룬�ͷų�λ��");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }


            }, String.valueOf(i)).start();
        }


    }
}
