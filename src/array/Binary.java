package array;

/**
 * @Author LX
 * @Date 2020/8/9 15:24
 * @Description 数组二分查找法
 */
public class Binary {

    public static void main(String[] args) {
        System.out.println(new Binary().binarySearch2(new int[]{1, 2, 3, 4, 5}, 4));
    }


    public int binarySearch2(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (right >= left) {
            int middle = (left + right) / 2;
            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;

    }


    public int binarySearch1(int[] arr, int target) {
        int middle = arr.length / 2;
        if (target == arr[middle]) {
            return middle;
        } else if (target > arr[middle]) {
            return binarySearch(arr, middle + 1, arr.length - 1, target);
        } else {
            return binarySearch(arr, 0, middle - 1, target);
        }
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (target == arr[middle]) {
            return middle;
        } else if (target > arr[middle]) {
            return binarySearch(arr, middle + 1, right, target);
        } else {
            return binarySearch(arr, left, middle - 1, target);
        }
    }
}
