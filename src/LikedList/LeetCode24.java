package LikedList;

/**
 * @Author LX
 * @Date 2020/8/13 20:28
 * @Description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class LeetCode24 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        new LeetCode24().swapPairs(root);
    }

    public ListNode swapPairs(ListNode head) {

        ListNode rootNode = new ListNode(-1);
        rootNode.next = head;
        head = rootNode;


        while (head.next != null && head.next.next != null) {
            ListNode node1 = head.next;
            ListNode node2 = head.next.next;
            ListNode nextNode = head.next.next.next;
            node1.next = nextNode;
            node2.next = node1;
            head.next = node2;
            head = head.next.next;
        }
        return rootNode.next;
    }
}
