package array;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author LX
 * @date 2018-11-14 12:59
 */
/*给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
    示例 1: 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].  输出: [-1,3,-1]
    解释: 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
          对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
          对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
          示例 2:
       输入: nums1 = [2,4], nums2 = [1,2,3,4]. 输出: [3,-1]
     解释:   对于num1中的数字2，第二个数组中的下一个较大数字是3。
             对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。*/
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = map.get(nums1[i]);
            if (integer == null) {
                nums1[i] = -1;
            } else {
                nums1[i] = integer;
            }

        }

        return nums1;
    }

    public static void main(String[] args) {
        int nums1[] = new int[]{2, 4};
        int nums2[] = new int[]{1, 2, 3, 4};
        int[] ints = NextGreaterElement.nextGreaterElement(nums1, nums2);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
