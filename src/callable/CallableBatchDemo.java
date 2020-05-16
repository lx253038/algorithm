package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author LX
 * @Date 2020/4/25 14:59
 * @Description 批量接收Callable返回值，即批量提交任务
 */
public class CallableBatchDemo {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        //提交Callable任务
        List<Future<Integer>> futureList = new ArrayList<>();
        Callable<Integer> callable = () -> {
            TimeUnit.MILLISECONDS.sleep(2000);
            int i = new Random().nextInt(100);
            System.out.println(i);
            return i;
        };


        for (int i = 0; i < 20; i++) {
            futureList.add(executorService.submit(callable));  //Callable方式返回一个Future对象可获取返回值
        }

        //executorService.shutdownNow();立即关闭线程池
        //优雅的关闭线程池（等待任务执行完毕）
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
