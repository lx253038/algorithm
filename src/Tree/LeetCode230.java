package Tree;

import java.util.Stack;

/**
 * @Author LX
 * @Date 2020/9/12 18:46
 * @Description 给定一个二叉搜索树，编写一个函数?kthSmallest?来查找其中第?k?个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * ?  2
 * 输出: 1
 */
public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode230().kthSmallest(Array2Tree.listToTree("[5,3,6,2,4,null,null,1]"), 3));
    }

}
