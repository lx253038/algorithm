package Tree;

/**
 * @Author LX
 * @Date 2020/9/5 20:09
 * @Description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明:?叶子节点是指没有子节点的节点。
 * 示例:?
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


    public static void main(String[] args) {
        System.out.println(new LeetCode112().hasPathSum(Array2Tree.listToTree("[1,2]"), 1));
    }
}
