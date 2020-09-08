package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/9/6 20:29
 * @Description 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明:?叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和?sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(root, sum, list, new LinkedList<>());
        return list;
    }

    public void bfs(TreeNode root, int sum, List<List<Integer>> resList, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.addLast(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            resList.add(new ArrayList<>(list));
        }
        bfs(root.left, sum - root.val, resList, list);
        bfs(root.right, sum - root.val, resList, list);
        // 重点，遍历完后，需要把当前节点remove出去，因为用的是同一个list对象来存所有的路径
        list.removeLast();
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode113().pathSum(Array2Tree.listToTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
    }
}
