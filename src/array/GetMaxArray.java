package array;

/**
 * @author LX
 * @date 2018-11-27 19:44
 * 递归找出数组中最大值
 */
public class GetMaxArray {
    public static int solution(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int a = solution(arr, left, mid);
        int b = solution(arr, mid + 1, right);
        return Math.max(a, b);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 7, 2, 1, 9, 10, 25};
        int solution = GetMaxArray.solution(arr, 0, arr.length - 1);
        System.out.println(solution);
    }
}
