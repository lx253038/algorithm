package Tree;

/**
 * @Author LX
 * @Date 2020/9/12 15:54
 * @Description ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
 * ����һ��������������������������
 * �ڵ��������ֻ����С�ڵ�ǰ�ڵ������
 * �ڵ��������ֻ�������ڵ�ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������
 * ʾ��?1:
 * <p>
 * ����:
 * 2
 * / \
 * 1   3
 * ���: true
 */
public class LeetCode98 {

    Integer min = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (min == null || min < root.val) {
            min = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode98().isValidBST(Array2Tree.listToTree("[2,1,3]")));
    }
}
