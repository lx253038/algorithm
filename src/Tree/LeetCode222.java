package Tree;

/**
 * @Author LX
 * @Date 2020/9/5 19:26
 * @Description ����һ����ȫ����������������Ľڵ������
 * ˵����
 * ��ȫ�������Ķ������£�����ȫ�������У�������ײ�ڵ����û�����⣬����ÿ��ڵ������ﵽ���ֵ������������һ��Ľڵ㶼�����ڸò�����ߵ�����λ�á�����ײ�Ϊ�� h �㣬��ò���� 1~?2h?���ڵ㡣
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * ���: 6
 */
public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode222().countNodes(Array2Tree.listToTree("[1,2,3,4,5,6,null]")));
    }
}
