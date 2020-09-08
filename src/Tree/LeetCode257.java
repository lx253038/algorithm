package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/9/6 19:42
 * @Description ����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ�
 * ʾ��:
 * ����:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * ���: ["1->2->5", "1->3"]
 * <p>
 * ����: ���и��ڵ㵽Ҷ�ӽڵ��·��Ϊ: 1->2->5, 1->3
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePaths(root, list, "");
        return list;
    }

    public void binaryTreePaths(TreeNode root, List<String> list, String str) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(str + root.val);
            return;
        }
        binaryTreePaths(root.left, list, str + root.val + "->");
        binaryTreePaths(root.right, list, str + root.val + "->");
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode257().binaryTreePaths(Array2Tree.listToTree("[1,2,3,null,5]")));
    }

}
