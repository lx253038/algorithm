package Tree;

/**
 * @Author LX
 * @Date 2020/9/6 21:26
 * @Description ����һ��������������ÿ����㶼���һ��?0-9?�����֣�ÿ���Ӹ���Ҷ�ӽڵ��·��������һ�����֡�
 * ���磬�Ӹ���Ҷ�ӽڵ�·�� 1->2->3 �������� 123��
 * ����Ӹ���Ҷ�ӽڵ����ɵ���������֮�͡�
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ʾ�� 1:
 * ����: [1,2,3]
 * 1
 * / \
 * 2   3
 * ���: 25
 * ����:
 * �Ӹ���Ҷ�ӽڵ�·�� 1->2 �������� 12.
 * �Ӹ���Ҷ�ӽڵ�·�� 1->3 �������� 13.
 * ��ˣ������ܺ� = 12 + 13 = 25.
 */
public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
//        return dfs(root, "");
        return dfs2(root, 0);
    }

    public int dfs(TreeNode root, String str) {
        if (root == null) {
            return 0;
        }
        StringBuilder builder = new StringBuilder(str).append(root.val);
        if (root.left == null && root.right == null) {

            return Integer.parseInt(builder.toString());
        }
        return dfs(root.left, builder.toString()) + dfs(root.right, builder.toString());
    }

    public int dfs2(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {

            return val;
        }
        return dfs2(root.left, val) + dfs2(root.right, val);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode129().sumNumbers(Array2Tree.listToTree("[4,9,0,5,1]")));
    }
}
