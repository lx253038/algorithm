package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LX
 * @date 2018/10/30 15:14
 */
/*
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
         例如，给定一个 3叉树 :
                        1
                    /   |   \
                   3    2    4
                /    \
               5      6

        返回其层序遍历:[[1],[3,2,4],[5,6]]
*/

public class LevelOrder {
    public List<List<Integer>> levelOrder(MoreNode root) {

        List<List<Integer>> resultlist = new ArrayList<>();
        if (root == null) {
            return resultlist;
        }
        Queue<MoreNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                MoreNode remove = queue.remove();
                list.add(remove.val);
                if (remove.children != null) {
                    for (MoreNode node : remove.children) {
                        queue.add(node);
                    }
                }

            }
            resultlist.add(list);

        }

        return resultlist;
    }

    public static void main(String[] args) {
        LevelOrder lo = new LevelOrder();
        List<MoreNode> moreNodes = new ArrayList<>();
        MoreNode moreNode1 = new MoreNode(11, null);
        MoreNode moreNode2 = new MoreNode(12, null);
        MoreNode moreNode3 = new MoreNode(13, null);
        moreNodes.add(moreNode1);
        moreNodes.add(moreNode2);
        moreNodes.add(moreNode3);
        MoreNode moreNode = new MoreNode(10, moreNodes);
        List<List<Integer>> lists = lo.levelOrder(moreNode);
        System.out.println(lists);
    }
}
