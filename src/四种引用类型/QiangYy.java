package 四种引用类型;

/**
 * @Author LX
 * @Date 2020/5/22 14:24
 * @Description 强引用
 * 把一个对象赋给一个引用变量，这个引用变量就是一个强引用。类似 “Object obj = new Object()” 这类的引用。
 * 当内存不足，JVM 开始垃圾回收，对于强引用的对象，**就算是出现了 OOM 也不会对该对象进行回收，打死都不收。**因此强引用有时也是造成 Java 内存泄露的原因之一。
 */
public class QiangYy {

    public static void main(String[] args) {
        Object object = new Object();
        Object ob1 = object;

        System.out.println(ob1);
        System.out.println(object);

        System.out.println("=======================ob1置为null后==================");
        object = null;
        System.gc();

        System.out.println(ob1);
        System.out.println(object);

    }

}
