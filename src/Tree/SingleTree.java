package Tree;

/**
 * @Author LX
 * @Date 2020/7/22 19:12
 * @Description ���������ÿ���ڵ㶼������ͬ��ֵ����ô�ö��������ǵ�ֵ��������
 * ֻ�и��������ǵ�ֵ������ʱ���ŷ��� true�����򷵻� false��
 * ���룺[1,1,1,1,1,null,1]  �����true
 * ���룺[2,2,2,5,2]  �����false
 */
public class SingleTree {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(2);

        System.out.println(new SingleTree().isUnivalTree(treeNode));

    }

//    Integer res;
//
//    public boolean isUnivalTree(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (res != null && res != root.val) {
//            return false;
//        } else {
//            res = root.val;
//        }
//        return isUnivalTree(root.left) && isUnivalTree(root.right);
//    }

    public boolean isUnivalTree(TreeNode root) {

        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && dfs(node.left, val) && dfs(node.right, val);
    }
}
