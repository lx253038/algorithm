package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

import LikedList.ListNode;

/**
 * @Author LX
 * @Date 2020/9/3 21:16
 * @Description 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode root = new ListNode(0);
        ListNode currNode = root;
        while (!queue.isEmpty()) {
            currNode.next = new ListNode(queue.poll());
            currNode = currNode.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[3];
        nodes[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        nodes[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        nodes[2] = new ListNode(2, new ListNode(6));
        System.out.println(new LeetCode23().mergeKLists(nodes));
    }
}
