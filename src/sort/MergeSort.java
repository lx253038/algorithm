package sort;

import java.util.Arrays;

/**
 * @author LX
 * @date 2018-11-27 19:44
 * �鲢����
 */
public class MergeSort {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(solution(left), solution(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, a = 0, b = 0; index < result.length; index++) {//a,b�൱�����������ָ���0��ʼ���ҵ�������С�Ķ�Ӧ��ָ���1
            if (a >= left.length) {         //���a�Ѿ����ڻ�������鳤�ȣ���˵��a��Ӧ�������ѱ�����
                result[index] = right[b];  //ֱ�ӽ�bָ���Ӧ��ֵ���뷵�ص������У�bָ������
                b++;
            } else if (b >= right.length) {
                result[index] = left[a];
                a++;
            } else if (left[a] > right[b]) {
                result[index] = right[b];
                b++;
            } else {
                result[index] = left[a];
                a++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] solution = MergeSort.solution(new int[]{4, 5, 7, 2, 1, 9, 10, 25, 17});
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}
