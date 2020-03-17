import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/12/18 14:22
 * @Description
 */
public class Test2 {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    private static int sum1 = 0;
    private static int sum2 = 0;

    public static void main(String[] args) {
        method1();
        System.out.println(sum1);
        System.out.println(sum2);
    }

    private static void method1() {

        new Thread(() -> {
            for (int i = 0; i <= 1000; i++) { //1000以内的素数多少个
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        sum1++;
                        try {
                            TimeUnit.MICROSECONDS.sleep(120);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            for (int i = 1001; i <= 2000; i++) { //1000以内的素数多少个
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        sum2++;
                    }
                }
            }
            countDownLatch.countDown();
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
