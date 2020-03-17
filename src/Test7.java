import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/11/22 16:52
 * @Description TODO
 */
public class Test7 {
    private volatile static int sum = 0;


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 500; i++) {
                sum += i;
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + ":sum=" + sum);
        }, "AAA");

        Thread t2 = new Thread(() -> {
            for (int i = 501; i <= 1000; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + ":sum=" + sum);
        }, "BBB");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(sum);
    }
}
