package math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author LX
 * @Date 2020/8/19 21:55
 * @Description дһ��?RecentCounter?�����������������
 * ��ֻ��һ��������ping(int t)������?t?�����Ժ���Ϊ��λ��ĳ��ʱ�䡣
 * ���ش� 3000 ����ǰ�����ڵ�?ping?����
 * �κδ���?[t - 3000, t]?ʱ�䷶Χ֮�ڵ� ping?�����ᱻ�������ڣ�������ǰ��ָ t?ʱ�̣��� ping��
 * ��֤ÿ�ζ� ping �ĵ��ö�ʹ�ñ�֮ǰ����� t ֵ��
 * ���룺inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * �����[null,1,2,3,3]
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
