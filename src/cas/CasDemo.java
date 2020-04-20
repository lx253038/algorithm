package cas;

/**
 * @Author LX
 * @Date 2020/4/19 12:35
 * @Description
 */
public class CasDemo implements Runnable {

    private volatile int a;

    public synchronized boolean compareAndSwap(int v1, int v2) {
        if (a == v1) {
            a = v2;
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + compareAndSwap(0, 1));
    }


    public static void main(String[] args) {
        CasDemo casDemo = new CasDemo();
        casDemo.a = 0;
        Thread thread1 = new Thread(casDemo, "aaa");
        Thread thread2 = new Thread(casDemo, "bbb");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(casDemo.a);
    }
}
