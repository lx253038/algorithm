package TenSorting;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2019-8-28 16:47
 * @Description ѡ������
 * ��������T(n) = O(n2)  ��������T(n) = O(n2)  ƽ�������T(n) = O(n2)
 * n����¼��ֱ��ѡ������ɾ���n-1��ֱ��ѡ������õ��������������㷨�������£�
 * ��ʼ״̬��������ΪR[1..n]��������Ϊ�գ�
 * ��i������(i=1,2,3��n-1)��ʼʱ����ǰ���������������ֱ�ΪR[1..i-1]��R(i..n����
 * ��������ӵ�ǰ��������-ѡ���ؼ�����С�ļ�¼ R[k]���������������ĵ�1����¼R������ʹR[1..i]��R[i+1..n)�ֱ��Ϊ��¼��������1�������������ͼ�¼��������1��������������
 * n-1�˽��������������ˡ�
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] ints = SelectionSort.selectionSort(new int[]{6, 12, 11, 20, 5, 7, 13, 56, 66, 2, 10, 11});
        System.out.println(Arrays.toString(ints));
    }

    private static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
        return array;
    }
}
