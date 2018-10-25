package Tree;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。
        说明: 叶子节点是指没有子节点的节点。
        示例:
        输入:
          1
        /   \
       2     3
        \
         5
        输出: ["1->2->5", "1->3"]
        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3*/
public class BinaryTreePaths {
    public List<String> binaryTreePath(TreeNode root) {
        List<String> list = new ArrayList<>();
        String s = "";
        list = search(root, s, list);
        return list;
    }

    List<String> search(TreeNode root, String s, List<String> list) {
        if (root == null) {
            return list;
        }

        if ("".equals(s)) {
            s += root.val;
        } else {
            s += "->" + root.val;
        }
        if (root.right == null && root.left == null) {
            list.add(s);
            return list;
        }
        list = search(root.left, s, list);
        list = search(root.right, s, list);


        return list;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> list = binaryTreePaths.binaryTreePath(root);
        System.out.println(list.toString());
    }
}
