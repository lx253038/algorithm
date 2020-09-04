package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

import LikedList.ListNode;

/**
 * @Author LX
 * @Date 2020/9/3 21:16
 * @Description ����һ���������飬ÿ�������Ѿ����������С�
 * ���㽫��������ϲ���һ�����������У����غϲ��������
 * ʾ�� 1��
 * ���룺lists = [[1,4,5],[1,3,4],[2,6]]
 * �����[1,1,2,3,4,4,5,6]
 * ���ͣ������������£�
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * �����Ǻϲ���һ�����������еõ���
 * 1->1->2->3->4->4->5->6
 * ʾ�� 2��
 * <p>
 * ���룺lists = []
 * �����[]
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
