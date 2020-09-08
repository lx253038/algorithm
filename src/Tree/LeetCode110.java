package Tree;

/**
 * @Author LX
 * @Date 2020/9/5 19:35
 * @Description ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
 * <p>
 * �����У�һ�ø߶�ƽ�����������Ϊ��
 * <p>
 * һ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������1��
 * <p>
 * ʾ�� 1:
 * <p>
 * ���������� [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(bfs(root.left, 1) - bfs(root.right, 1)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int bfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(bfs(root.left, depth + 1), bfs(root.right, depth + 1));
    }

    public boolean isBalanced2(TreeNode root) {

        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode110().isBalanced2(Array2Tree.listToTree("[3,9,20,null,null,15,7]")));
    }

}
