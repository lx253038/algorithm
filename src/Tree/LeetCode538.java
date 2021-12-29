package Tree;

/**
 * @Author LX
 * @Date 2020/9/21 20:03
 * @Description 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */
public class LeetCode538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        convertBST(root,0);
        return root;
    }
    private int convertBST(TreeNode root,int val){
        if(root==null)return 0;
        root.val=convertBST(root.right,val)+root.val+val;
        return root.val+convertBST(root.left,root.val)-val;
    }



    public static void main(String[] args) {
        System.out.println(new LeetCode538().convertBST(Array2Tree.listToTree("[1,0,4,-2,null,3]")));
        System.out.println(new LeetCode538().convertBST2(Array2Tree.listToTree("[1,0,4,-2,null,3]")));
    }

}
