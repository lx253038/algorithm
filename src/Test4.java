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
                    break;  //�жϺ��������˳���ǰ�߳�
                }
            }
            System.out.println("��Ȼ��ִ����.....");
        });
        thread.start();
        Thread.sleep(1000);

        thread.interrupt();//�жϵ�ǰ�߳�
        System.out.println(Thread.currentThread().getName() + "=================");

    }
}
