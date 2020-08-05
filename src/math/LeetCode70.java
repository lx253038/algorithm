package math;

/**
 * @Author LX
 * @Date 2020/7/29 21:42
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 解题思路（第n个台阶只能从第n-1或者n-2个上来。到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法，已经知道了第1个和第2个台阶的走法，一路加上去。）
 */
public class LeetCode70 {

    public static void main(String[] args) {
        System.out.println(new LeetCode70().climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2;
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }

}
