package Tree;

/**
 * @author LX
 * @date 2018-11-15 13:44
 */
/*������������������дһ�����������������Ƿ���ͬ�� ����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ�
 ʾ�� 1: ����:
          1         1
        / \       / \
        2   3     2   3         [1,2,3],   [1,2,3]  ���: true
ʾ�� 2:  ����:
         1          1
        /            \
        2             2      [1,2],     [1,null,2]   ���: false
*/
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }
}
