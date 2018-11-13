package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LX
 * @date 2018-11-13 17:42
 */
/*给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
        例如： 给定二叉树 [3,9,20,null,null,15,7],输出[[15,7],[9,20],[3]]
                3
               / \
              9  20
                /  \
               15   7

*/
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> reslist = new ArrayList<>();
        if (root == null) {
            return reslist;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            reslist.add(list);
        }
        for (int i = 0; i < reslist.size() / 2; i++) {
            List<Integer> list = reslist.get(i);
            reslist.set(i, reslist.get(reslist.size() - (i + 1)));
            reslist.set(reslist.size() - (i + 1), list);

        }

        return reslist;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        List<List<Integer>> leafsimilar = levelOrderBottom.levelOrderBottom(root);
        System.out.println(leafsimilar);
    }
}
