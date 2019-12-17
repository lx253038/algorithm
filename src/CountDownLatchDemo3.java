import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2019/10/27 13:36
 * @Description TODO
 */
public class CountDownLatchDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();
        for (int i = 1; i <= 30; i++) {
            new Thread(student, i + "").start();
/*            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "��ѧ���뿪�ˡ�����");
                countDownLatch.countDown();
            }, i+"").start();*/
        }
        Student.countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "����ѧ��ȫ���뿪���೤�����ˣ�");
    }
}

class Student implements Runnable {
    public static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {

            Thread.sleep(0);
            System.out.println(Thread.currentThread().getName() + "��ѧ���뿪�ˡ�����");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();

            lock.unlock();
        }
    }
}