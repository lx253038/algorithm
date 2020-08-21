package LikedList;

import java.util.HashSet;

/**
 * @Author LX
 * @Date 2020/8/19 21:29
 * @Description 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 */
public class LeetCode141 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode two = new ListNode(2);
        root.next = two;
        two.next = new ListNode(3);
        two.next.next = two;
        System.out.println(new LeetCode141().hasCycle2(root));
    }


    public boolean hasCycle(ListNode head) {
        ListNode twoNode = head;
        while (twoNode != null && twoNode.next != null) {
            if (head.next == twoNode.next.next) {
                return true;
            }
            head = head.next;
            twoNode = twoNode.next.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        HashSet hashSet = new HashSet<ListNode>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }
}
