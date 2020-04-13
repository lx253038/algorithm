package threadLocal;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author LX
 * @Date 2020/3/19 18:32
 * @Description ThreadLocal  自己set内容到threadLocal中   在其他方法中可直接使用get()方法拿到，可以省略方法的传参
 */
public class ThreadLocalDemo2 {

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        threadLocal.set(new User("张三", 30));

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