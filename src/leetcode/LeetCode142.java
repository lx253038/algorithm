package leetcode;

import LikedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lixin
 * @date: 2021/12/23 9:29 ÏÂÎç
 * @description:
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }


    public ListNode detectCycl2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                System.out.println(head.val);
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        new LeetCode142().detectCycle(listNode1);

    }
}
