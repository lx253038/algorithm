package Tree;

/**
 * @Author LX
 * @Date 2020/9/12 16:41
 * @Description����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е�?key?��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�
 * һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
 * �����ҵ���Ҫɾ���Ľڵ㣻
 * ����ҵ��ˣ�ɾ������
 * ˵���� Ҫ���㷨ʱ�临�Ӷ�Ϊ?O(h)��h Ϊ���ĸ߶ȡ�
 * ʾ��:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * ������Ҫɾ���Ľڵ�ֵ�� 3���������������ҵ� 3 ����ڵ㣬Ȼ��ɾ������
 * <p>
 * һ����ȷ�Ĵ��� [5,4,6,2,null,null,7], ����ͼ��ʾ��
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * ��һ����ȷ���� [5,2,6,null,4,null,7]��
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        return dfs(root, key);
    }

    //��̽ڵ�
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    //ǰ���ڵ�
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode dfs(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                root.val = successor(root);
                root.right = dfs(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = dfs(root.left, root.val);
            }
        } else if (root.val > key) {
            root.left = dfs(root.left, key);
        } else {
            root.right = dfs(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        new LeetCode450().deleteNode(Array2Tree.listToTree("[5,3,6,2,4,null,7]"), 5);
    }

}
