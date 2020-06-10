package semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/6/9 21:11
 * @Description ģ��ʮ�ҵ�λ��ȡ�����֤���ܿ�ʼ�ɻ�
 * semaphore.acquire(x) ��ȡx�����֤��Ĭ��Ϊ1����δ��ȡ�����֤��������֪����ȡ�����ִ��
 * semaphore.release(x) �ͷ�x�����֤��Ĭ��1�����˷���д��finally������У�������Ϊ�쳣�����޷��ͷŵ�������
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(6);

        //1.acquire(10)������ȡ���֤���������ܴ������õ�������������������
        //2.release(10)�����ͷ����֤���������ܴ��ڻ�ȡ����������������֤����������
        //3.release(2)�����ͷ����֤����������С�ڻ�ȡ�����������ܻ����������������ȡ�����ͷż�����
//        new Thread(() -> {
//            try {
//                semaphore.acquire(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                semaphore.release(6);
//            }
//        }, "AAA").start();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(2);
                    System.out.println(Thread.currentThread().getName() + "����ȡ�����֤,��ʼ�ɻ����������");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(2);
                    System.out.println(Thread.currentThread().getName() + "���ͷ����֤����������������");

                }
            }, "�߳�" + i).start();
        }

    }
}
