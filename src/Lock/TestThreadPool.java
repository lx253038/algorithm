package Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author LX
 * @Date 2019/9/7 12:23
 * @Description �̳߳أ��ṩ��һ���̶߳��У������б��������еȴ�״̬���̣߳������˴��������ٶ���Ŀ������������Ӧ�ٶȣ�
 * �̳߳صĴ�����ر�  ����Runnable�̺߳�Callableʵ��
 * java.util.concurrent.Executor :�����߳�ʹ�ú͵��ȵĸ��ӿ�
 *    |--**ExecutorService  ���ӽӿ� �̳߳ص���Ҫ�ӿ�
 *           |--ThreadPoolExecutor :�̳߳ص�ʵ����
 *           |--ScheduledExectorService  �ӽӿ� �������̵߳ĵ���
 *                |--ScheduledThreadPoolExecutor :�̳�ThreadPoolExecutor  ʵ����ScheduledExecutorService�ӿ�
 * ������ Executors
 * ExecutorService   newFixedThreadPool(5):�����̶���С���̳߳�
 * ExecutorService   newSingleThreadExecutor():���������̳߳� ֻ����һ���߳�
 * ExecutorService   newCachedThreadPool(): �����̳߳أ��߳��������̶����ɸ��������Զ������߳�����
 * ScheduledExecutorService  newScheduledThreadPool(5) :�̶���С���̳߳أ�����ʱ���߶�ʱִ������
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
