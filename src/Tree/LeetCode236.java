package Tree;

/**
 * @Author LX
 * @Date 2020/9/17 21:36
 * @Description ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 * <p>
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 * <p>
 * ���磬�������¶�����:? root =?[3,5,1,6,2,0,8,null,null,7,4]
 * ʾ�� 1:
 * <p>
 * ����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * ���: 3
 * ����: �ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3��
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : (right == null ? left : root);
    }

}
