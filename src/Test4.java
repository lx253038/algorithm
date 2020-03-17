/**
 * @Author LX
 * @Date 2019/11/1 11:00
 * @Description TODO
 */
public class Test4 {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println(Thread.currentThread().getName() + ":i=" + i);
                if (Thread.currentThread().isInterrupted()) {
                    break;  //中断后不能立即退出当前线程
                }
            }
            System.out.println("仍然在执行中.....");
        });
        thread.start();
        Thread.sleep(1000);

        thread.interrupt();//中断当前线程
        System.out.println(Thread.currentThread().getName() + "=================");

    }
}
