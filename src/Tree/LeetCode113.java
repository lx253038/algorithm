package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/9/6 20:29
 * @Description ����һ����������һ��Ŀ��ͣ��ҵ����дӸ��ڵ㵽Ҷ�ӽڵ�·���ܺ͵��ڸ���Ŀ��͵�·����
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ʾ��:
 * �������¶��������Լ�Ŀ���?sum = 22��
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * ����:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(root, sum, list, new LinkedList<>());
        return list;
    }

    public void bfs(TreeNode root, int sum, List<List<Integer>> resList, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.addLast(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            resList.add(new ArrayList<>(list));
        }
        bfs(root.left, sum - root.val, resList, list);
        bfs(root.right, sum - root.val, resList, list);
        // �ص㣬���������Ҫ�ѵ�ǰ�ڵ�remove��ȥ����Ϊ�õ���ͬһ��list�����������е�·��
        list.removeLast();
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode113().pathSum(Array2Tree.listToTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
    }
}
