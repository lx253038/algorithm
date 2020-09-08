package Tree;

/**
 * @Author LX
 * @Date 2020/9/5 20:41
 * @Description ���������������������Ҷ��֮�͡�
 * <p>
 * ʾ����
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * ������������У���������Ҷ�ӣ��ֱ��� 9 �� 15�����Է��� 24��
 */
public class LeetCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return left ? root.val : 0;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);

    }

    int sum;

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }
        sumOfLeftLeaves2(root.left);
        sumOfLeftLeaves2(root.right);
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode404().sumOfLeftLeaves2(Array2Tree.listToTree("[3,9,20,null,null,15,7]")));
    }
}
