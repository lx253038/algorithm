package Tree;

/**
 * @Author LX
 * @Date 2020/8/24 21:03
 * @Description ����һ��������������ÿ����㶼�����һ������ֵ��
 * �ҳ�·���͵��ڸ�����ֵ��·��������
 * ·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
 * ������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������
 * ʾ����
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * ���� 3���͵��� 8 ��·����:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class LeetCode437 {
    int length = 0;

    public int pathSum(TreeNode root, int sum) {
        BST(root, sum);
        if (root != null) {
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return length;
    }

    public void BST(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        if (0 == sum) {
            length++;
        }
        BST(node.left, sum);
        BST(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(new LeetCode437().pathSum(Array2Tree.listToTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
        System.out.println(new LeetCode437().pathSum(root, 8));
    }
}
