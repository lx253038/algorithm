package array;

import java.util.TreeSet;

/**
 * @Author LX
 * @Date 2020/8/12 20:02
 * @Description ���������� nums �У��Ƿ���������±� i �� j��ʹ��?nums [i] ��?nums [j]?�Ĳ�ľ���ֵС�ڵ��� t �������� i �� j �Ĳ�ľ���ֵҲС�ڵ��� ? ��
 * ��������򷵻� true�������ڷ��� false��
 * ����: nums = [1,2,3,1], k = 3, t = 0
 * ���: true
 */
public class LeetCode220 {
    public static void main(String[] args) {
        System.out.println(new LeetCode220().containsNearbyAlmostDuplicate(new int[]{1, 2147483647}, 1, 2147483647));
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long res = treeSet.ceiling((long) nums[i] - (long) t);
            if (res != null && res <= (long) nums[i] + (long) t) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
