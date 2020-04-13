package threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author LX
 * @Date 2020/3/17 19:39
 * @Description threadLocal initialValue()Ϊÿ���̳߳�ʼ������  �����߳��е���ʱthreadLocal.get()ʱ ThreadLocalMap�д���ʱֱ�ӷ��أ������ھͳ�ʼ��������ÿ���߳��еĶ����Ǹ���Ĳ�������̰߳�ȫ����
 */
public class ThreadLocalDemo1 {


    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

    /*        static ThreadLocal<SimpleDateFormat> threadLocal=new ThreadLocal(){
                @Override
                protected SimpleDateFormat initialValue() {
                     return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                }
            };*/
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        System.out.println(simpleDateFormat);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute(() -> {

                System.out.println(Thread.currentThread().getName() + " " + formatDate(finalI));
            });
        }

        executorService.shutdown();
    }


    public static String formatDate(int sec) {
        Date date = new Date(sec * 1000);
        return threadLocal.get().format(date);
    }

}

