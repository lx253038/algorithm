package Tree;

/**
 * @Author LX
 * @Date 2020/9/12 15:44
 * @Description ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 * ���磬�������¶���������:? root =?[6,2,8,0,4,7,9,null,null,3,5]
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * ���: 6
 * ����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
 */
public class LeetCode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
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
        System.out.println(new LeetCode235().lowestCommonAncestor(Array2Tree.listToTree("[6,2,8,0,4,7,9,null,null,3,5]"), new TreeNode(2), new TreeNode(5)).val);
    }

}
