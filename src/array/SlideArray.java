package array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author LX
 * @Date 2020/8/10 21:28
 * @Description 返回滑动窗口数据的最大值
 * 每k个元素进行比较取出当前的最大值
 */
public class SlideArray {
    public static void main(String[] args) {
        new SlideArray().test(new int[]{1, 2, 5, 67, 3, 45, 61}, 3);
    }


    public void test(int[] arr, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (queue.isEmpty()) {
                queue.add(arr[i]);
                continue;
            } else if (queue.size() == k) {
                queue.poll();
            }
            while (!queue.isEmpty() && queue.peek() <= arr[i]) {
                queue.poll();
            }
            queue.add(arr[i]);
            if (i >= k - 1) {
                System.out.println(queue.peek());
            }
        }
    }
}
