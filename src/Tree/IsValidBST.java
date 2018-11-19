package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LX
 * @date 2018-11-19 9:35
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addToList(root, list);
        if (list != null && !list.isEmpty() && list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) >= list.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void addToList(TreeNode root, List<Integer> list) {
        if (root != null) {
            addToList(root.left, list);
            list.add(root.val);
            addToList(root.right, list);
        }
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(6);
        IsValidBST ib = new IsValidBST();
        System.out.println(ib.isValidBST(tree));

    }
}
