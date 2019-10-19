package Thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author LX
 * @Date 2019/10/8 10:28
 * @Description timer创建多线程，实现定时任务
 */
public class TimerThread {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "6666666");
            }
        }, 5, 1000);

        System.out.println(Thread.currentThread().getName() + "完毕！");
    }
}
