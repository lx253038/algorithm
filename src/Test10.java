import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author LX
 * @Date 2019/11/25 19:30
 * @Description TODO
 */
public class Test10 {
    private volatile static Integer sum = 0;

    private static Integer n = 100;

    private static Integer latchSize = 5; //线程数量

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int avg = n / latchSize;
        int rem = n % latchSize;
        int left, right;
        for (int i = 1; i <= latchSize; i++) {
            left = (i - 1) * avg + 1;
            right = i == latchSize ? (i * avg + rem) : (i * avg);

            FutureTask<Integer> task1 = new FutureTask<>(new ThreadDemo1(left, right));
            /* System.out.println("=============================");*/
            Thread thread1 = new Thread(task1);
            thread1.start();
            /* System.out.println("left->" + left + "   right->" + right);*/
            int s = task1.get();

            /*       sum += s;*/

        }


        System.out.println("----------------");
        System.out.println(sum);
        long start2 = System.currentTimeMillis();
        System.out.println(start2 - start);


    }


}

class ThreadDemo1 implements Callable<Integer> {

    private int left;

    private int right;

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + " sum:" + sum);
            /*   TimeUnit.SECONDS.sleep(2);*/
        }

        return sum;
    }

    public ThreadDemo1(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
