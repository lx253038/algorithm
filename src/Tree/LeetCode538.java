package Tree;

/**
 * @Author LX
 * @Date 2020/9/21 20:03
 * @Description ����һ��������������Binary Search Tree��������ת����Ϊ�ۼ�����Greater Tree)��ʹ��ÿ���ڵ��ֵ��ԭ���Ľڵ�ֵ�������д������Ľڵ�ֵ֮�͡�
 * ���磺
 * <p>
 * ����: ԭʼ����������:
 * 5
 * /   \
 * 2     13
 * <p>
 * ���: ת��Ϊ�ۼ���:
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
