package array;

/**
 * @Author LX
 * @Date 2020/7/23 21:51
 * @Description
 */
public class Leetcode11 {

    public static void main(String[] args) {
        System.out.println(new Leetcode11().minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Leetcode11().minArray1(new int[]{3, 4, 5, 1, 2}));
    }

    //从头到尾遍历
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    //二分法
    public int minArray1(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            // 找到中间位置。
            int mid = left + (right - left) / 2;
            // 判断找到比自己前面和后面元素都小的元素。
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        // 返回找到的最小值。
        return numbers[left];
    }

}
