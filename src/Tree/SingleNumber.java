package Tree;

/*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1: 输入: [2,2,1] 输出: 1
示例 2: 输入: [4,1,2,1,2] 输出: 4
*/

public class SingleNumber {

    public int oneNumber(int[] nums) {
        //异或方式  a ^ b ^ a=b;(异或的性质)
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }
        return temp;
        //哈希表方式
        /*Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.remove(i);
            }
        }
        return map.entrySet().iterator().next().getKey();*/
    }


    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        int i = singleNumber.oneNumber(new int[]{1, 2, 1, 4, 2});
        System.out.println(i);
    }
}
