package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/8/26 21:08
 * @Description (��̬�滮)����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
 * ���ڵĽ�� ������ָ���� �±� �� ��һ�����±� ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣
 * ���磬���������Σ�
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * �Զ����µ���С·����Ϊ?11������2?+?3?+?5?+?1?= 11����
 */
public class LeetCode120 {


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        int[][] dp = new int[triangle.size()][triangle.size()];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[triangle.size() - 1][0];
        for (int i = 1; i < triangle.size(); i++) {
            min = Math.min(min, dp[triangle.size() - 1][i]);
        }

        return min;
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new LeetCode120().minimumTotal(triangle));
    }
}
