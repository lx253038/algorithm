package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/9/6 19:42
 * @Description 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明:?叶子节点是指没有子节点的节点
 * 示例:
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePaths(root, list, "");
        return list;
    }

    public void binaryTreePaths(TreeNode root, List<String> list, String str) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(str + root.val);
            return;
        }
        binaryTreePaths(root.left, list, str + root.val + "->");
        binaryTreePaths(root.right, list, str + root.val + "->");
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode257().binaryTreePaths(Array2Tree.listToTree("[1,2,3,null,5]")));
    }

}
