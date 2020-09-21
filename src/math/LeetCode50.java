package math;

/**
 * @Author LX
 * @Date 2020/9/19 18:48
 * @Description 实现?pow(x, n)?，即计算 x 的 n 次幂函数。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例?2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 */
public class LeetCode50 {


    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    double quickMul2(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }


    public static void main(String[] args) {
        Math.pow(2, 10);
        System.out.println(new LeetCode50().myPow(2.0, 10));
        System.out.println(new LeetCode50().myPow2(2.0, 10));
    }

}
