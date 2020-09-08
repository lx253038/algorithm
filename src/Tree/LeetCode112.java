package Tree;

/**
 * @Author LX
 * @Date 2020/9/5 20:09
 * @Description ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ʾ��:?
 * �������¶��������Լ�Ŀ��� sum = 22��
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


    public static void main(String[] args) {
        System.out.println(new LeetCode112().hasPathSum(Array2Tree.listToTree("[1,2]"), 1));
    }
}
