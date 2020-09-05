package Tree;

/**
 * @Author LX
 * @Date 2020/9/4 20:52
 * @Description ����һ�����������ҳ�����С��ȡ�
 * ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ����������?[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ����������С��� ?2.
 */
public class LeetCode111 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode111().minDepth(Array2Tree.listToTree("[3,9,20,null,null,15,7]")));
    }
}
