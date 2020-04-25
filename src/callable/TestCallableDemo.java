package callable;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/9/4 20:42
 * @Description ʹ��Callable����ִ���߳� �����շ���ֵ
 */
public class TestCallableDemo {

    public static void main(String[] args) {
//        ThreadDemo threadDemo = new ThreadDemo();
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0; i <= 100000; i++) {
                sum += i;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("�ж��쳣������ȡ����====");
            }
            return sum;
        });
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("==========�߳�ִ����==============");
        try {
            System.out.println(task.get(1000, TimeUnit.MILLISECONDS));   //FutureTask �����ڱ���
        } catch (Exception e) {
            System.out.println("��ʱ�쳣���涨ʱ����δ��ȡ�������ȡ������");

            System.out.println("����ȡ���Ƿ�ɹ���" + task.cancel(true));

            System.out.println("�����Ƿ���ɣ�" + task.isDone());  //�����Ƿ����
            try {
                System.out.println(task.get());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("�����Ƿ���ɣ�" + task.isDone());  //�����Ƿ����

            System.out.println("�������ʱ��ȡ���Ƿ�ɹ���" + task.cancel(true));

        }
        System.out.println("==========�߳�ִ�����==============");
    }
}

//class ThreadDemo implements Callable<Integer> {
//
//    @Override
//    public Integer call() throws Exception {
//        int sum = 0;
//        for (int i = 0; i <= 100000; i++) {
//            sum += i;
//        }
//        TimeUnit.MILLISECONDS.sleep(2000);
//        return sum;
//    }
//}