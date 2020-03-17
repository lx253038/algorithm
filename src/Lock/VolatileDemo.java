package Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LX
 * @Date 2019/10/29 19:58
 * @Description 验证volatile的内存可见性
 */
public class VolatileDemo {

    public static volatile int number = 0;

    //原子整型（具有原子性）
    public static AtomicInteger integer = new AtomicInteger(0);

    public static void addNumber() {
        number++;
        integer.getAndIncrement();
    }

    public static void main(String[] args) {
        //验证可见性
/*        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 60;
            System.out.println(Thread.currentThread().getName() + "线程修改了number的值，number=" + number);

        }, "AAA").start();
        //不加volatile 修饰number，当线程AAA修改number后 main线程无法获取更新后的值 程序在此一直循环
        //当使用volatile后，线程AAA 修改后 main线程立即获取到了被修改后的值 由此验证了volatile的内存可见性
        while (number == 0) {
        }
        System.out.println(Thread.currentThread().getName() + "线程,number=" + number);*/
        //验证不具有原子性
        //创建10个线程 循环1000次number++;理想状态下 最后number应该等于10000，  实际结果总是小于10000 所以不具有原子性
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                for (int j = 0; j < 1000; j++) {
                    addNumber();
                }
            }, i + "").start();
        }
        while (Thread.activeCount() > 2) {

            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "线程(普通整型，不具备原子性)，number：" + number);
        System.out.println(Thread.currentThread().getName() + "线程(原子整型，具有原子性)，integer：" + integer);

    }


}


