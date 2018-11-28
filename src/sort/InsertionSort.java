package sort;

/**
 * @author LX
 * @date 2018-11-27 19:58
 * ≤Â»Î≈≈–Ú
 */
public class InsertionSort {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return arr;

    }
/*    public static int[] solution(int[] array) {

        if (array== null || array.length < 2) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;

    }*/


    public static void main(String[] args) {
        int[] solution = InsertionSort.solution(new int[]{4, 5, 7, 2, 1, 9, 10, 25, 0, -5});
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}
