package array;

import java.util.HashMap;
import java.util.Map;

/*����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������

        ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�

        ʾ��:

        ���� nums = [2, 7, 11, 15], target = 9

        ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
        ���Է��� [0, 1]
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