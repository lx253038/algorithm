package array;

/**
 * @Author LX
 * @Date 2020/8/10 19:29
 * @Description ����һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ��������Ƴ���������³��ȡ�
 * ���� nums = [3,2,2,3], val = 3,
 * ����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
public class LeetCode27 {
    public static void main(String[] args) {
        System.out.println(new LeetCode27().removeElement(new int[]{1, 1, 2}, 0));

    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
