package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import lombok.Data;

/**
 * @Author LX
 * @Date 2020/4/16 20:03
 * @Description
 */
public class AtomicUpdater implements Runnable {

    private static Student s1 = new Student();

    private static Student s2 = new Student();

    AtomicIntegerFieldUpdater<Student> updater = AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");

    public static void main(String[] args) {
        AtomicUpdater atomicUpdater = new AtomicUpdater();
        Thread thread1 = new Thread(atomicUpdater, "AAA");
        Thread thread2 = new Thread(atomicUpdater, "BBB");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(s1.getAge());
        System.out.println(s2.getAge());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            s1.setAge(s1.getAge() + 1);
            updater.getAndAdd(s2, 10);
        }
    }

}

@Data
class Student {

    String name;

    volatile int age;

}
