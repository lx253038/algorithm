package sort;

import java.util.Arrays;

/**
 * @author LX
 * @date 2018-11-27 19:44
 * 归并排序
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
        for (int index = 0, a = 0, b = 0; index < result.length; index++) {//a,b相当于两个数组的指针从0开始，找到两边最小的对应的指针加1
            if (a >= left.length) {         //如果a已经大于或等于数组长度，则说明a对应的数组已遍历完
                result[index] = right[b];  //直接将b指针对应的值放入返回的数组中，b指针自增
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
