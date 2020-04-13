package threadLocal;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author LX
 * @Date 2020/3/19 18:32
 * @Description ThreadLocal  �Լ�set���ݵ�threadLocal��   �����������п�ֱ��ʹ��get()�����õ�������ʡ�Է����Ĵ���
 */
public class ThreadLocalDemo2 {

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        threadLocal.set(new User("����", 30));

        service1();

    }

    private static void service1() {
        System.out.println("service1 " + threadLocal.get());
        service2();
    }

    private static void service2() {
        System.out.println("service2 " + threadLocal.get());

    }


}

@Data
@AllArgsConstructor
class User {
    private String name;

    private int age;
}