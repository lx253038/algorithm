package Tree;

/*给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

        输入:
         3
        /  \
       9   20
          /   \
         15    7
     输出: [3, 14.5, 11]
解释: 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevel {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList();
        queue.add(root);

        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                sum += cur.val;

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add((double) sum / size);

        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        AverageOfLevel averageOfLevel = new AverageOfLevel();
        List<Double> list = averageOfLevel.averageOfLevels(root);
        System.out.println(list.toString());

    }
}
