package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LX
 * @date 2018/10/30 14:35
 */
/*�����������飬��дһ���������������ǵĽ�����
        ʾ�� 1:
        ����: nums1 = [1,2,2,1], nums2 = [2,2]
        ���: [2]
        ʾ�� 2:
        ����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        ���: [9,4]
        ˵��:
        �������е�ÿ��Ԫ��һ����Ψһ�ġ�
        ���ǿ��Բ�������������˳��
*/
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set1.contains(nums2[j])) {
                set2.add(nums2[j]);
            }
        }
        int[] arr = new int[set2.size()];
        int a = 0;
        for (Integer val : set2) {
            arr[a] = val;
            a++;
        }

        return arr;
    }

    public static void main(String[] args) {
        Intersection st = new Intersection();
        int[] arr = st.intersection(new int[]{1, 7, 3, 4, 8, 6}, new int[]{1, 2, 3, 4, 3, 8});
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                res.append(arr[i] + ",");
            } else {
                res.append(arr[i] + "]");
            }
        }
        System.out.println(res.toString());
    }
}
