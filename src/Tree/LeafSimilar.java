package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LX
 * @date 2018/10/30 14:04
 */
/*
请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
        输入:
         3
        /  \
       9   20
          /   \
         15    7
        举个例子，如上图所示，给定一颗叶值序列为 (9, 15, 7) 的树。
        如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
        如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
*/


public class LeafSimilar {
    public boolean leafsimilar(TreeNode root1, TreeNode root2) {

        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        searchLeaf(root1, s1);
        searchLeaf(root2, s2);
        if (s1.size() == s2.size()) {
            for (int i = 0; i < s1.size(); i++) {
                if (!s1.get(i).equals(s2.get(i))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private void searchLeaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
            searchLeaf(root.left, list);
            searchLeaf(root.right, list);
    }

    public static void main(String[] args) {


        LeafSimilar leafSimilar = new LeafSimilar();
        boolean leafsimilar = leafSimilar.leafsimilar(Array2Tree.listToTree("[3,5,1,6,2,9,8,null,null,7,4]"), Array2Tree.listToTree("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10]"));
        System.out.println(leafsimilar);

    }

}
