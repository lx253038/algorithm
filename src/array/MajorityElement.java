package array;

import java.util.Arrays;

/**
 * @author LX
 * @date 2018/10/31 9:55
 */

/*给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ? n/2 ? 的元素。
        你可以假设数组是非空的，并且给定的数组总是存在众数。
        示例 1:输入: [3,2,3]输出: 3
        示例 2:输入: [2,2,1,1,1,2,2]输出: 2
*/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        //map记录出现次数
/*        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        int result=0;
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>max){
                    max=map.get(nums[i]);
                    result =nums[i];
                }
            }else {
                map.put(nums[i],1);
                if(map.get(nums[i])>max){
                    max=map.get(nums[i]);
                    result =nums[i];
                }
            }

        }
        return result;*/
        //对数组中元素排序，返回中间的元素
        Arrays.sort(nums);
        return nums[nums.length / 2];


    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int i = me.majorityElement(new int[]{2, 2, 6, 9, 10, 2, 2});
        System.out.println(i);
    }
}
