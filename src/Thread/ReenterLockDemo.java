package Thread;

/**
 * @author LX
 * @date 2019-6-27 19:15
 */

//¿ÉÖØÈëËø£¨µİ¹éËø£©
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> phone.sendMsg(), String.valueOf(i)).start();
        }
    }
}


class Phone {
    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getId() + "=====================sendMsg================");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "*********************sendEmail***************");
    }
}
