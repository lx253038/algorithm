package array;

/**
 * @Author LX
 * @Date 2020/8/10 19:05
 * @Description ����һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * �������� nums = [1,1,2],
 * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
public class LeetCode26 {

    public static void main(String[] args) {
        System.out.println(new LeetCode26().removeDuplicates(new int[]{1, 1, 1}));

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }
}
