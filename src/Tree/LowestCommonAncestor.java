package Tree;

/**
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0       4       7       9
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * ���: 6
 * ����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
 * <p>
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * ���: 2
 * ����: �ڵ� 2 �ͽڵ� 4 ��������������� 2, ��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        LowestCommonAncestor lc = new LowestCommonAncestor();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(9);
        root = lc.lowestCommonAncestor(root, p, q);
        System.out.println(root.val);
    }

}
