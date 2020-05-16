package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2020/4/27 21:29
 * @Description ģ���û�ʹ��һ���˻�ͬʱ��ATM�͹�̨ȡǮ
 */
public class ABCount {

    static int countSum = 1000;


    static ReentrantLock lock = new ReentrantLock(true);


    public static void main(String[] args) {


        new Thread(() -> ABCount.AIM(69), "AAA").start();

        new Thread(() -> ABCount.guiTai(30), "BBB").start();


    }


    public static void AIM(int count) {

        while (true) {
            lock.lock();
            try {
                if (countSum <= 0) {
                    System.out.println(Thread.currentThread().getName() + "ATM�˻�����ѿա�����");
                    return;
                }
                if (count > countSum) {
                    System.out.println(Thread.currentThread().getName() + "ATM���㡣������");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "ATM����ȡǮ������������");
                countSum = countSum - count;
                System.out.println(Thread.currentThread().getName() + "ATM�ɹ�ȡ��:" + count + "Ԫ��ʣ���" + countSum);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


    }


    public static void guiTai(int count) {

        while (true) {
            lock.lock();
            try {
                if (countSum <= 0) {
                    System.out.println(Thread.currentThread().getName() + "��̨�˻�����ѿա�����");
                    return;
                }
                if (count > countSum) {
                    System.out.println(Thread.currentThread().getName() + "��̨���㡣������");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "��̨����ȡǮ������������");
                countSum = countSum - count;
                System.out.println(Thread.currentThread().getName() + "��̨�ɹ�ȡ��:" + count + "Ԫ��ʣ���" + countSum);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }


}
