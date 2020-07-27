package array;

/**
 * @Author LX
 * @Date 2020/7/23 21:51
 * @Description
 */
public class Leetcode11 {

    public static void main(String[] args) {
        System.out.println(new Leetcode11().minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Leetcode11().minArray1(new int[]{3, 4, 5, 1, 2}));
    }

    //��ͷ��β����
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    //���ַ�
    public int minArray1(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            // �ҵ��м�λ�á�
            int mid = left + (right - left) / 2;
            // �ж��ҵ����Լ�ǰ��ͺ���Ԫ�ض�С��Ԫ�ء�
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        // �����ҵ�����Сֵ��
        return numbers[left];
    }

}
