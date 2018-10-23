package Tree;

/*����һ���ǿն�����, ����һ����ÿ��ڵ�ƽ��ֵ��ɵ�����.

        ����:
         3
        /  \
       9   20
          /   \
         15    7
     ���: [3, 14.5, 11]
����: ��0���ƽ��ֵ�� 3,  ��1���� 14.5, ��2���� 11. ��˷��� [3, 14.5, 11].*/

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
