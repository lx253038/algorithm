package array;

/**
 * @author LX
 * @date 2018-11-14 19:32
 */
/*����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
      ʾ��: ����: [0,1,0,3,12]  ���: [1,3,12,0,0]
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
        //����������ѭ�����ٶ�����
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
