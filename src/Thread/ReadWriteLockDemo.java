package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * @author LX
 * @date 2019-7-1 19:56
 */

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCaChe myCaChe = new MyCaChe();

        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                myCaChe.set(index + "", index);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                myCaChe.get(index + "");
            }, String.valueOf(i + 10)).start();
        }
    }
}


class MyCaChe {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void set(String key, Object value) {


        lock.writeLock().lock();
        try {
            System.out.println("=========================" + key + "正在写入  ");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println("=========================" + key + "写入完成  ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }

    public Object get(String key) {
        Object o = null;
        lock.readLock().lock();
        try {
            System.out.println("=========================正在读取:" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o = map.get(key);
            System.out.println("=========================读取完成（" + key + ":" + o + "）");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return o;
    }
}