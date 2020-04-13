package threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/3/17 19:39
 * @Description threadLocal��ÿ���߳���set��ֵ ֻ�е�ǰ�߳���get�����������̵߳ĸ��루ÿ���̶߳����Լ��Ķ�������
 */
public class ThreadLocalDemo3 {


    static ThreadLocal threadLocal = new ThreadLocal();


    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("=====main=====");


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            threadLocal.set(Thread.currentThread().getName() + ":1111");
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            System.out.println("=================================");
        });
        executorService.execute(() -> {
            threadLocal.set(Thread.currentThread().getName() + ":2222");
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            System.out.println("=================================");
        });
        executorService.execute(() -> {
            threadLocal.set(Thread.currentThread().getName() + ":3333");
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            System.out.println("=================================");
        });
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
                System.out.println("=================================");
            });
        }

        System.out.println(threadLocal.get());

        executorService.shutdown();
    }


}

