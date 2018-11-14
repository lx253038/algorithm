package array;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author LX
 * @date 2018-11-14 12:59
 */
/*��������û���ظ�Ԫ�ص����� nums1 �� nums2 ������nums1 �� nums2 ���Ӽ����ҵ� nums1 ��ÿ��Ԫ���� nums2 �е���һ��������ֵ��
    nums1 ������ x ����һ������Ԫ����ָ x �� nums2 �ж�Ӧλ�õ��ұߵĵ�һ���� x ���Ԫ�ء���������ڣ���Ӧλ�����-1��
    ʾ�� 1: ����: nums1 = [4,1,2], nums2 = [1,3,4,2].  ���: [-1,3,-1]
    ����: ����num1�е�����4�����޷��ڵڶ����������ҵ���һ����������֣������� -1��
          ����num1�е�����1���ڶ�������������1�ұߵ���һ���ϴ������� 3��
          ����num1�е�����2���ڶ���������û����һ����������֣������� -1��
          ʾ�� 2:
       ����: nums1 = [2,4], nums2 = [1,2,3,4]. ���: [3,-1]
     ����:   ����num1�е�����2���ڶ��������е���һ���ϴ�������3��
             ����num1�е�����4���ڶ���������û����һ����������֣������� -1��*/
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
