package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/7/23 22:16
 * @Description  ½â´ð´íÎó´ýÍêÉÆ
 */
public class Leetcode863 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.left.right = new TreeNode(3);
        treeNode.right.left.right.right = new TreeNode(4);
        System.out.println(new Leetcode863().distanceK(treeNode, new TreeNode(2), 2));
    }

    List<Integer> list = new ArrayList<>();
    int index = 0;
    Boolean left;
    TreeNode target;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.target=target;
        if (root.val == target.val) {
            findVal(root, K, 0);
        } else {
            findTarget(root.left, target, K, 1, true);
            findTarget(root.right, target, K, 1, false);
        }
        if (index == K) {
            list.add(root.val);
        }

        if (left == null || K == 0) {
            return list;
        } else if (left) {
            if (index > K) {
                findVal(root.left, index - K, 1);
            } else {
                findVal(root.right, K - index, 1);
            }
        } else {
            if (index > K) {
                findVal(root.right, index - K, 1);
            } else if (index < K) {
                findVal(root.left, K - index, 1);
            } else {
                findVal(root, K, 0);
            }
        }
        return list;
    }

    public void findTarget(TreeNode root, TreeNode target, int K, int index, boolean left) {
        if (root == null) {
            return;
        }
        if (root.val == target.val) {
            findVal(root, K, 0);
            this.left = left;
            this.index = index;
        }
        findTarget(root.left, target, K, index + 1, left);
        findTarget(root.right, target, K, index + 1, left);
    }


    public void findVal(TreeNode root, int K, int curr) {
        if (root == null) {
            return;
        }
        if (K == curr) {
            if(K==0||target.val!=root.val){
                list.add(root.val);
            }
        }
        if (root.left != null) {
            findVal(root.left, K, curr + 1);
        }
        if (root.right != null) {
            findVal(root.right, K, curr + 1);
        }
    }

}
