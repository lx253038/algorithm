package math;

/**
 * @Author LX
 * @Date 2020/9/21 20:55
 * @Description 实现?int sqrt(int x)?函数。
 * 计算并返回?x?的平方根，其中?x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * ?    由于返回类型是整数，小数部分将被舍去。
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l <=r) {
            long middle = (l + r) / 2;
            if (middle * middle == x) {
                return (int) middle;
            } else if (middle * middle > x) {
                r=middle-1;
            } else {
                l=middle+1;
            }
        }
        return (int) (l-1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode69().mySqrt(0));
    }

}
