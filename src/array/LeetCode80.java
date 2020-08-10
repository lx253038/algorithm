package array;

/**
 * @Author LX
 * @Date 2020/8/10 19:44
 * @Description ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�
 * ���� nums = [1,1,1,2,2,3],
 * ����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3 ��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
public class LeetCode80 {

    public static void main(String[] args) {
        System.out.println(new LeetCode80().removeDuplicates(new int[]{1, 1, 1, 1, 1, 1}));

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 1] || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    /**
     * �����ظ�Ԫ����಻�ܳ���k��
     *
     * @param nums
     * @param k
     * @return
     */
    public int removeDuplicates(int[] nums, int k) {
        if (nums.length <= k) return nums.length;
        int index = k;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != nums[index - k]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
