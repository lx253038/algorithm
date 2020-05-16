package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LX
 * @Date 2020/4/27 21:29
 * @Description 模拟用户使用一个账户同时在ATM和柜台取钱
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
                    System.out.println(Thread.currentThread().getName() + "ATM账户金额已空。。。");
                    return;
                }
                if (count > countSum) {
                    System.out.println(Thread.currentThread().getName() + "ATM余额不足。。。。");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "ATM正在取钱。。。。。。");
                countSum = countSum - count;
                System.out.println(Thread.currentThread().getName() + "ATM成功取出:" + count + "元，剩余金额：" + countSum);

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
                    System.out.println(Thread.currentThread().getName() + "柜台账户金额已空。。。");
                    return;
                }
                if (count > countSum) {
                    System.out.println(Thread.currentThread().getName() + "柜台余额不足。。。。");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "柜台正在取钱。。。。。。");
                countSum = countSum - count;
                System.out.println(Thread.currentThread().getName() + "柜台成功取出:" + count + "元，剩余金额：" + countSum);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }


}
