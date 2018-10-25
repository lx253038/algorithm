package Tree;

import java.util.ArrayList;
import java.util.List;

/*
����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����
        ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
        ʾ��:
        ����:
          1
        /   \
       2     3
        \
         5
        ���: ["1->2->5", "1->3"]
        ����: ���и��ڵ㵽Ҷ�ӽڵ��·��Ϊ: 1->2->5, 1->3*/
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
