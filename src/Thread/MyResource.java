package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LX
 * @date 2019-7-11 19:23
 * BlockingQueue
 */


public class MyResource {

    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> queue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        queue = blockingQueue;
    }

    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(4));
        new Thread(() -> {
            try {
                myResource.product();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AAA").start();
        new Thread(() -> {
            try {
                myResource.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BBB").start();

        TimeUnit.SECONDS.sleep(10);
        myResource.stop();

    }

    public void product() throws Exception {
        String data = null;
        boolean rres;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            rres = queue.offer(data, 2L, TimeUnit.SECONDS);
            if (rres) {
                System.out.println(Thread.currentThread().getName() + "\t������гɹ���" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t�������ʧ�ܣ�" + data);
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "\tFLAG=false,ֹͣ������������");
    }

    public void consumer() throws Exception {
        String result;
        while (FLAG) {
            result = queue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                System.out.println(Thread.currentThread().getName() + "\t��ʱ2Sδȡ������ֹͣȡ����������");
                FLAG = false;
            } else {
                System.out.println(Thread.currentThread().getName() + "\t���Ѷ��гɹ���" + result);

            }
        }
    }

    public void stop() {
        FLAG = false;
        System.out.println(Thread.currentThread().getName() + "\t���ϰ��ͣ��ֹͣ��������������");
    }


}
