package sort;

/**
 * @author LX
 * @date 2018-11-27 19:44
 * πÈ≤¢≈≈–Ú
 */
public class MergeSort1 {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        sortProcess(arr, 0, arr.length - 1);
        return arr;
    }

    public static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        marge(arr, L, mid, R);
    }

    public static void marge(int[] arr, int L, int mid, int R) {
        int[] result = new int[R - L + 1];
        for (int index = 0, a = L, b = mid + 1; index < result.length; index++) {
            if (a > mid) {
                result[index] = arr[b++];
            } else if (b > R) {
                result[index] = arr[a++];
            } else if (arr[a] > arr[b]) {
                result[index] = arr[b++];
            } else {
                result[index] = arr[a++];
            }

        }
        for (int i = 0; i < result.length; i++) {
            arr[L + i] = result[i];
        }
    }


    public static void main(String[] args) {
        int[] solution = MergeSort1.solution(new int[]{4, 5, 7, 2, 1, 9, 10, 25, 17});
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}
