import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author LX
 * @Date 2019/11/2 12:53
 * @Description 带版本号的原子类操作  解决了ABA问题
 */
public class AtomicStamped {

    private static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    int stamp = reference.getStamp();
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boolean b = reference.compareAndSet(100, 100, stamp, stamp + 1);
                    if (b) {
                        System.out.println(Thread.currentThread().getName() + ":" + "(是否修改成功：" + b + ",当前版本号：" + reference.getStamp() + ")");
                    } else {
                        System.out.println(Thread.currentThread().getName() + ":" + "(修改失败：" + b + ",拿到的版本号：" + stamp + ",当前版本号：" + reference.getStamp() + ")");
                    }
                }

            }, "" + i).start();
        }

    }
}
