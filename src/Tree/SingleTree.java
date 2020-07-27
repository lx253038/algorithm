package Tree;

/**
 * @Author LX
 * @Date 2020/7/22 19:12
 * @Description 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * 输入：[1,1,1,1,1,null,1]  输出：true
 * 输入：[2,2,2,5,2]  输出：false
 */
public class SingleTree {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(2);

        System.out.println(new SingleTree().isUnivalTree(treeNode));

    }

//    Integer res;
//
//    public boolean isUnivalTree(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (res != null && res != root.val) {
//            return false;
//        } else {
//            res = root.val;
//        }
//        return isUnivalTree(root.left) && isUnivalTree(root.right);
//    }

    public boolean isUnivalTree(TreeNode root) {

        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && dfs(node.left, val) && dfs(node.right, val);
    }
}
