package Tree;

/**
 * @Author LX
 * @Date 2020/9/12 15:54
 * @Description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例?1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 */
public class LeetCode98 {

    Integer min = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (min == null || min < root.val) {
            min = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode98().isValidBST(Array2Tree.listToTree("[2,1,3]")));
    }
}
