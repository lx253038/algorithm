package Tree;

/**
 * @Author LX
 * @Date 2020/8/15 20:19
 * @Description ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 * ������������: [-10,-3,0,5,9],
 * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class LeetCode108 {

    public static void main(String[] args) {
        new LeetCode108().sortedArrayToBST2(new int[]{-10, -3, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int middle = nums.length / 2;
        TreeNode root = new TreeNode(nums[middle]);
        appendTree(root, 0, middle - 1, nums);
        appendTree(root, middle + 1, nums.length - 1, nums);
        return root;
    }


    public void appendTree(TreeNode root, int left, int right, int[] nums) {
        if (right >= left) {
            int middle = (left + right) / 2;
            if (nums[middle] < root.val) {
                root.left = new TreeNode(nums[middle]);
                appendTree(root.left, left, middle - 1, nums);
                appendTree(root.left, middle + 1, right, nums);
            } else {
                root.right = new TreeNode(nums[middle]);
                appendTree(root.right, left, middle - 1, nums);
                appendTree(root.right, middle + 1, right, nums);
            }
        }
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);

        treeNode.left = helper(nums, left, middle - 1);
        treeNode.right = helper(nums, middle + 1, right);
        return treeNode;
    }

}
