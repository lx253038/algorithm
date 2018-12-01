package array;

/**
 * @author LX
 * @date 2018-12-1 18:21
 */
/*���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
        ( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )�� ���ҳ�������С��Ԫ�ء� ����Լ��������в������ظ�Ԫ�ء�
        ʾ�� 1: ����: [3,4,5,1,2]   ���: 1  ʾ�� 2:  ����: [4,5,6,7,0,1,2]  ���: 0
*/
public class FindMin {

    public static int findMin(int[] nums) {
        //���ַ� O(logN)
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l == r);
        return nums[l];
        //һ�α��� O(N)
/*        for (int i = 1; i < nums.length-1; i++) {
             if(nums[i-1]>nums[i]&&nums[i+1]>nums[i]){
                 return nums[i];
             }
        }
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }else{
            return nums[nums.length-1];
        }*/

    }


    public static void main(String[] args) {
        System.out.println(FindMin.findMin(new int[]{10, 11, 12, 1, 2, 3, 4, 5}));
    }

}
