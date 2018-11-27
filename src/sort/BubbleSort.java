package sort;

/**
 * @author LX
 * @date 2018-11-27 19:44
 * √∞≈›≈≈–Ú
 */
public class BubbleSort {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] solution = BubbleSort.solution(new int[]{4, 5, 7, 2, 1, 9, 10, 25});
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}
