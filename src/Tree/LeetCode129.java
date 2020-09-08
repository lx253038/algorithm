package Tree;

/**
 * @Author LX
 * @Date 2020/9/6 21:26
 * @Description 给定一个二叉树，它的每个结点都存放一个?0-9?的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明:?叶子节点是指没有子节点的节点。
 * 示例 1:
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 */
public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
//        return dfs(root, "");
        return dfs2(root, 0);
    }

    public int dfs(TreeNode root, String str) {
        if (root == null) {
            return 0;
        }
        StringBuilder builder = new StringBuilder(str).append(root.val);
        if (root.left == null && root.right == null) {

            return Integer.parseInt(builder.toString());
        }
        return dfs(root.left, builder.toString()) + dfs(root.right, builder.toString());
    }

    public int dfs2(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {

            return val;
        }
        return dfs2(root.left, val) + dfs2(root.right, val);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode129().sumNumbers(Array2Tree.listToTree("[4,9,0,5,1]")));
    }
}
