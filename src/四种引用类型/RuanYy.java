package 四种引用类型;

import java.lang.ref.SoftReference;

/**
 * @Author LX
 * @Date 2020/5/22 14:31
 * @Description 软引用(软引用是一种相对强引用弱化了一些的引用 ， 需要用java.lang.ref.SoftReference 类来实现)
 * 软引用用来描述一些还有用，但并非必需的对象。
 * 对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收范围之中并进行第二次回收。
 * 如果这次回收还是没有足够的内存，才会抛出内存溢出异常。
 * 对于只有软引用的对象来说：当系统内存充足时它不会被回收，当系统内存不足时它才会被回收。
 */
public class RuanYy {

    public static void main(String[] args) {
        softRefMemoryEnough();
        System.out.println("------内存不够用的情况------");
        softRefMemoryNotEnough();


    }

    //内存充足时
    private static void softRefMemoryEnough() {
        Object object = new Object();
        //ob1软引用于object
        SoftReference<Object> ob1 = new SoftReference<>(object);
        System.out.println(object);
        System.out.println(ob1.get());

        object = null;
        System.gc();
        System.out.println(object);
        //软引用不会被回收
        System.out.println(ob1.get());

    }

    //内存不足时
    private static void softRefMemoryNotEnough() {
        Object object = new byte[1024 * 1024 * 3];
        //ob1软引用于object
        SoftReference<Object> ob1 = new SoftReference<>(object);
        System.out.println(object);
        System.out.println(ob1.get());

        object = null;
        //在创建对象超出JVM内存，先尝试去回收软引用再创建对象，如果仍然内存不足才会报错
        byte[] bytes = new byte[1024 * 1024 * 2];
        System.out.println(object);
        //软引用会被回收
        System.out.println(ob1.get());
    }
}
