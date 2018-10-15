package array;

import java.util.HashMap;
import java.util.Map;

/*给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

        你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
*/

class SumTwo {
    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = target - arr[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(arr[i], i);
        }

        System.out.println("No two sum solution");
        return null;


    }

    public static void main(String[] args) {
        SumTwo st=new SumTwo();
        int[] arr=st.twoSum(new int[]{1,7,3,4,8,6},12);
        StringBuilder res=new StringBuilder();
        res.append("[");
        for (int i = 0; i <arr.length ; i++) {
            if(i!=arr.length-1){
                res.append(arr[i]+",");
            }else{
                res.append(arr[i]+"]");
            }
        }
        System.out.println(res.toString());
    }
}