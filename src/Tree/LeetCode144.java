package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author LX
 * @Date 2020/9/1 18:02
 * @Description ����һ������������������?ǰ��?������
 * ?ʾ��:
 * ����: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * ���: [1,2,3]
 */
public class LeetCode144 {

    private List<Integer> res = new ArrayList<>();

    //�ݹ鷽ʽ
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    //����
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                res.add(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode144().preorderTraversal2(Array2Tree.listToTree("[1,null,2,3]")));
    }

}
