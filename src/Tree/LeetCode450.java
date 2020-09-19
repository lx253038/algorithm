package Tree;

/**
 * @Author LX
 * @Date 2020/9/12 16:41
 * @Description给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的?key?对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为?O(h)，h 为树的高度。
 * 示例:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        return dfs(root, key);
    }

    //后继节点
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    //前驱节点
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode dfs(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                root.val = successor(root);
                root.right = dfs(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = dfs(root.left, root.val);
            }
        } else if (root.val > key) {
            root.left = dfs(root.left, key);
        } else {
            root.right = dfs(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        new LeetCode450().deleteNode(Array2Tree.listToTree("[5,3,6,2,4,null,7]"), 5);
    }

}
