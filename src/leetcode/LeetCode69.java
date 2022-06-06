package leetcode;

/**
 * @author: lixin
 * @date: 2022/2/8 9:16 обнГ
 * @description:
 */
public class LeetCode69 {


    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int ans = x / middle;
            if (ans == middle) {
                return middle;
            } else if (ans > middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    public int mySqrt2(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }



    public static void main(String[] args) {
        System.out.println(new LeetCode69().mySqrt2(250000));
    }
}
