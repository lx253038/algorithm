package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/8/25 21:13
 * @Description ����һ����������, ����������ҵ����и�����ĵ��������У����������еĳ���������2��
 * ʾ��
 * ����: [4, 6, 7, 7]
 * ���: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * ˵��:
 * ��������ĳ��Ȳ��ᳬ��15��
 * �����е�������Χ�� [-100,100]��
 * ���������п��ܰ����ظ����֣���ȵ�����Ӧ�ñ���Ϊ������һ�������
 */
public class LeetCode491 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode491().findSubsequences(new int[]{4, 7, 7, 9}));
    }
}
