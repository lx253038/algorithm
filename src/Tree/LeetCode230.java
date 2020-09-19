package Tree;

import java.util.Stack;

/**
 * @Author LX
 * @Date 2020/9/12 18:46
 * @Description ����һ����������������дһ������?kthSmallest?���������е�?k?����С��Ԫ�ء�
 * ˵����
 * ����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����
 * ʾ�� 1:
 * ����: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * ?  2
 * ���: 1
 */
public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode230().kthSmallest(Array2Tree.listToTree("[5,3,6,2,4,null,null,1]"), 3));
    }

}
