package TenSorting;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2019-8-28 16:14
 * @Description ð������
 * ��������T(n) = O(n)   ��������T(n) = O(n2)   ƽ�������T(n) = O(n2)
 * �Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԣ�����������Ԫ��Ӧ�û�����������
 * ������е�Ԫ���ظ����ϵĲ��裬�������һ����
 * �ظ�����1~3��ֱ��������ɡ�
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = BubbleSort.bubbleSort(new int[]{6, 12, 11, 20, 5, 7, 13, 56, 66, 20, 10, 11});
        System.out.println(Arrays.toString(ints));
    }

    private static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }


}
