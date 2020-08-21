package math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author LX
 * @Date 2020/8/19 21:55
 * @Description 写一个?RecentCounter?类来计算最近的请求。
 * 它只有一个方法：ping(int t)，其中?t?代表以毫秒为单位的某个时间。
 * 返回从 3000 毫秒前到现在的?ping?数。
 * 任何处于?[t - 3000, t]?时间范围之内的 ping?都将会被计算在内，包括当前（指 t?时刻）的 ping。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 */
public class RecentCounter {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(642));
        System.out.println(recentCounter.ping(1849));
        System.out.println(recentCounter.ping(4921));

    }

    Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        queue.offer(t);
        while (t - 3000 > queue.peek()) {
            queue.poll();
        }

        return queue.size();
    }
}
