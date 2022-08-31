/**
 * @Author LX
 * @Date 2020/1/7 19:40
 * @Description
 */
public class Test9 {

    private static final Object object = new Object();
    private static int count = 0;


    public static void main(String[] args) {

        Runnable runnable = () -> {
            while (count <= 100) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    object.notify();
                    if (count <= 100) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };


        new Thread(runnable, "AAA").start();
        new Thread(runnable, "BBB").start();
        System.out.println("11111111111");
    }


}
