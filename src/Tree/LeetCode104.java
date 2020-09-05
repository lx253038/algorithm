package Tree;

/**
 * @Author LX
 * @Date 2020/9/4 20:41
 * @Description ����һ�����������ҳ��������ȡ�
 * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ʾ����
 * ���������� [3,9,20,null,null,15,7]��
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ��������������?3
 */
public class LeetCode104 {

    int depth;

    public int maxDepth(TreeNode root) {

        dfs(root, 1);
        return depth;
    }

    public void dfs(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        if (currDepth > depth) {
            depth = currDepth;
        }
        dfs(root.left, currDepth + 1);
        dfs(root.right, currDepth + 1);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode104().maxDepth2(Array2Tree.listToTree("[3,9,20,null,null,15,7]")));
    }

}
