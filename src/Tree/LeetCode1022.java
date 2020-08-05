package Tree;

/**
 * @Author LX
 * @Date 2020/8/5 21:44
 * @Description
 */
public class LeetCode1022 {

    int countSum = 0;

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return countSum;
    }

    public void sumRootToLeaf(TreeNode root, int sum) {
        if (root != null) {
            sum = 2 * sum + root.val;

            if (root.left == null && root.right == null) {
                countSum += sum;
            } else {
                sumRootToLeaf(root.left, sum);
                sumRootToLeaf(root.right, sum);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(1);
        System.out.println(new LeetCode1022().sumRootToLeaf(treeNode));
    }
}
