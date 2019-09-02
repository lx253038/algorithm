package TenSorting;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2019-8-28 16:14
 * @Description 冒泡排序
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
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
