package 四种引用类型;

import java.lang.ref.WeakReference;

/**
 * @Author LX
 * @Date 2020/5/22 14:51
 * @Description 弱引用（弱引用需要用java.lang.ref.WeakReference类来实现，它比软引用的生存期更短）
 * 被弱引用关联的对象只能生存到下一次垃圾收集发生之前。当垃圾收集器工作时，无论当前内存是否足够，都会回收掉只被弱引用关联的对象。
 * 对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管 JVM 的内存空间是否足够，都会回收该对象占用的内存。
 */
public class RuoYy {

    public static void main(String[] args) {
        Object object = new Object();
        //ob1弱引用于object
        WeakReference<Object> ob1 = new WeakReference<>(object);
        System.out.println(object);
        System.out.println(ob1.get());

        object = null;
        //执行垃圾回收，弱引用直接也会被回收掉
        System.gc();

        System.out.println(object);
        System.out.println(ob1.get());

    }
}
