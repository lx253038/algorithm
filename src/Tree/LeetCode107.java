package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author LX
 * @Date 2020/9/2 20:46
 * @Description ����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
 * ���������� [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * �������Ե����ϵĲ�α���Ϊ��
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resList.add(0, list);
        }
        return resList;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        dfs(root, 0, resList);
        for (int i = resList.size() - 1; i >= 0; i--) {
            res.add(resList.get(i));
        }
        return res;
    }

    public void dfs(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode107().levelOrderBottom2(Array2Tree.listToTree("[3,9,20,null,null,15,7]")));
    }
}
