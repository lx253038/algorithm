package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LX
 * @date 2019-6-26 18:08
 */

public class NotSafeDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //ArrayList 线程不安全  会报java.util.ConcurrentModificationException  即并发修改错误
        //导致原因：并发争抢修改导致，一节线程正在写入，另一个线程过来抢夺资源导致数据不一致异常，并发修改异常
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 6));
                /*  System.out.println(list);*/
            }, String.valueOf(i)).start();
        }
        //解决方案
        //1.使用线程安全的Vector( public synchronized boolean add(E e) 使用synchronized修饰线程安全，但并发效率降低)
/*        Vector<String> vector = new Vector<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                vector.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(vector + ":" + Thread.currentThread().getName());
            }, String.valueOf(i)).start();
        }*/
        //2.借助Collections类的synchronizedList方法创建一个线程安全的list
/*        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                list2.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(list2);
            }, String.valueOf(i)).start();
        }*/
        //3.new 一个CopyOnWriteArrayList，使用CopyOnWrite的写时复制、读写分离的思想
        List<String> list3 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                list3.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(list3);
            }, String.valueOf(i)).start();
        }
        ;
    }

}
