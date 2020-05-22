package 四种引用类型;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author LX
 * @Date 2020/5/22 15:04
 * @Description 虚引用(虚引用需要java.lang.ref.PhantomReference 来实现 。)
 * 它不能单独使用也不能通过它访问对象，虚引用必须和引用队列（RefenenceQueue）联合使用。
 * 设置虚引用的唯一目的，就是在这个对象被回收器回收的时候收到一个系统通知或者后续添加进一步的处理。
 */
public class XuYy {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(phantomReference.get());

        o1 = null;
        System.gc();
        System.out.println("执行垃圾回收");
        Thread.sleep(3000);

        System.out.println(o1);
        System.out.println(referenceQueue.poll()); //引用队列中
        System.out.println(phantomReference.get());
    }

}
