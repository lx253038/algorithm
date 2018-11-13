package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LX
 * @date 2018-11-13 18:34
 */

/*
����: [1,null,2,3]
        1
        \
          2
        /
        3

        ���: [1,3,2]
    */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        order(root, list);
        return list;
    }

    public void order(TreeNode root, List<Integer> list) {
        if (root != null) {
            /*   list.add(root.val);//ǰ�����*/
            order(root.left, list);
            list.add(root.val);  //�������
            order(root.right, list);
            /*   list.add(root.val);//�������*/

        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        InorderTraversal it = new InorderTraversal();
        List<Integer> list = it.inorderTraversal(root);
        System.out.println(list);
    }

}
