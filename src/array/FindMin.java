package array;

/**
 * @author LX
 * @date 2018-12-1 18:21
 */
/*假设按照升序排序的数组在预先未知的某个点上进行了旋转。
        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 请找出其中最小的元素。 你可以假设数组中不存在重复元素。
        示例 1: 输入: [3,4,5,1,2]   输出: 1  示例 2:  输入: [4,5,6,7,0,1,2]  输出: 0
*/
public class FindMin {

    public static int findMin(int[] nums) {
        //二分法 O(logN)
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
        //一次遍历 O(N)
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
