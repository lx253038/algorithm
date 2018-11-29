package array;

/**
 * @author LX
 * @date 2018-11-23 15:41
 */
/*��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�����һ���������� nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�
����Լ��� nums[-1] = nums[n] = -�ޡ�
ʾ�� 1:����: nums = [1,2,3,1] ���: 2  ����: 3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
ʾ�� 2: ����: nums = [1,2,1,3,5,6,4]   ���: 1 �� 5 ����: ��ĺ������Է������� 1�����ֵԪ��Ϊ 2�����߷������� 5�� ���ֵԪ��Ϊ 6��
*/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] > nums[m + 1]) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}