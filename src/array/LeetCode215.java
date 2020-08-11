package array;

import java.util.PriorityQueue;

/**
 * @Author LX
 * @Date 2020/8/10 21:17
 * @Description ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * ʾ�� 1:
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 */
public class LeetCode215 {


    public static void main(String[] args) {
        System.out.println(new LeetCode215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
