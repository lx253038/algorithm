import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author LX
 * @Date 2019/10/27 13:27
 * @Description TODO
 */
public class ConcurrentModificationEx {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new CopyOnWrite()).start();

        }
    }

}

class CopyOnWrite implements Runnable {
    private static List<String> list = new CopyOnWriteArrayList();

    static {
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
    }


    @Override
    public void run() {
        for (String s : list) {
            System.out.println(Thread.currentThread().getName() + ":" + s);
            list.add("111");
        }

        System.out.println(Thread.currentThread().getName() + "size:" + list.size() + ":" + list);
    }
}