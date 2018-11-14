package array;

/**
 * @author LX
 * @date 2018-11-14 19:32
 */
/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
      示例: 输入: [0,1,0,3,12]  输出: [1,3,12,0,0]
*/
public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (index != i) {
                    nums[++index] = nums[i];
                } else {
                    ++index;
                }
            }
        }
        for (index++; index < nums.length; index++) {
            nums[index] = 0;
        }
        return nums;
        //进行了两次循环，速度稍慢
/*        for (int i = 0; i <nums.length-1 ; i++) {
            int a=i+1;
              if(nums[i]==0){
                  while (nums[a]==0&&a!=nums.length-1){
                      a++;
                  }
                  int tmp=nums[a];
                  nums[a]=nums[i];
                  nums[i]=tmp;
                  System.out.println(nums);
              }
        }*/
    }

    public static void main(String[] args) {
        int[] ints = MoveZeroes.moveZeroes(new int[]{0, 1, 3, 0, 5, 0});
        for (int i : ints) {
            System.out.print(i + ",");
        }
    }
}
