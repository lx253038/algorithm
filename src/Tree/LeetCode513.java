package Tree;

/**
 * @Author LX
 * @Date 2020/8/27 21:14
 * @Description 给定一个二叉树，在树的最后一行找到最左边的值。
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出:
 * 1
 */
public class LeetCode513 {

    int deep = 0;
    int min = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return min;
    }

    public void dfs(TreeNode root, int a) {
        if (root == null) {
            return;
        }
        if (a > deep) {
            min = root.val;
            deep = a;
        }
        dfs(root.left, a + 1);
        dfs(root.right, a + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(new LeetCode513().findBottomLeftValue(treeNode));
    }
}
