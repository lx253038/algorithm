package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author LX
 * @Date 2020/4/25 14:59
 * @Description ��������Callable����ֵ���������ύ����
 */
public class CallableBatchDemo {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        //�ύCallable����
        List<Future<Integer>> futureList = new ArrayList<>();
        Callable<Integer> callable = () -> {
            TimeUnit.MILLISECONDS.sleep(2000);
            int i = new Random().nextInt(100);
            System.out.println(i);
            return i;
        };


        for (int i = 0; i < 20; i++) {
            futureList.add(executorService.submit(callable));  //Callable��ʽ����һ��Future����ɻ�ȡ����ֵ
        }

        //executorService.shutdownNow();�����ر��̳߳�
        //���ŵĹر��̳߳أ��ȴ�����ִ����ϣ�
        executorService.shutdown();
        System.out.println(executorService.isTerminated());
        System.out.println(executorService.isShutdown());

//        for (int i = 0; i < futureList.size(); i++) {
//            try {
//                System.out.println(futureList.get(i).get());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }
}
