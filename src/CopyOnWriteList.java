import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/3/23 21:18
 * @Description CopyOnWriteArrayList ����list���ڶ��߳���ͬʱ���ж�д����
 * @Ex ConcurrentModificationException ����ڶ��߳���ʹ��ArrayList��д���� ����׳������޸��쳣
 */
public class CopyOnWriteList {


    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
        arrayList.add("111");
        arrayList.add("22");
        arrayList.add("33");
        arrayList.add("44");
        arrayList.add("55");

        RunableTest runableTest = new RunableTest(arrayList);
        new Thread(runableTest, "AAA").start();
        new Thread(runableTest, "BBB").start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(arrayList);
    }
}

class RunableTest implements Runnable {
    private List<String> arrayList;

    public RunableTest(List arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public void run() {
        for (String s : arrayList) {
            arrayList.add(Thread.currentThread().getName() + "1111");
            System.out.println(s);

        }
    }
}

