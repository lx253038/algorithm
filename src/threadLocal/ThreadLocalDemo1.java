package threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author LX
 * @Date 2020/3/17 19:39
 * @Description threadLocal initialValue()为每个线程初始化对象  当在线程中调用时threadLocal.get()时 ThreadLocalMap中存在时直接返回，不存在就初始化操作，每个线程中的对象都是隔离的不会存在线程安全问题
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

