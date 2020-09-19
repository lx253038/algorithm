package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/9/15 21:39
 * @Description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class LeetCode46 {

    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return resList;
        }
        dfs(nums, 0, new ArrayList<>());
        return resList;
    }

    public void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            resList.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, index + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode46().permute(new int[]{1, 2, 3}));
    }
}
