package Tree;

/**
 * @Author LX
 * @Date 2020/9/4 21:28
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树?[1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * ?
 * <p>
 * 但是下面这个?[1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode101().isSymmetric(Array2Tree.listToTree("[1,2,2,3,4,4,3]")));
    }
}
