/**
 * @Author LX
 * @Date 2019/11/22 19:04
 * @Description TODO
 */
public class Test8 {
    static int sum;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new ThreadDemo(1, 50));
        Thread thread2 = new Thread(new ThreadDemo(51, 100));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(sum);


    }

    static class ThreadDemo implements Runnable {
        private int begin;

        private int end;


        @Override
        public void run() {
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + ":sum=" + sum);
        }

        public ThreadDemo(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}

