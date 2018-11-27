package sort;

/**
 * @author LX
 * @date 2018-11-27 19:58
 * —°‘Ò≈≈–Ú
 */
public class SelectionSort {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] solution = SelectionSort.solution(new int[]{4, 5, 7, 2, 1, 9, 10, 25, 0});
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}
