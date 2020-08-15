package LikedList;

import java.util.Stack;

/**
 * @Author LX
 * @Date 2020/8/13 19:21
 * @Description 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        new LeetCode206().reverseList2(root);
    }

    public ListNode reverseList2(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }


    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            ListNode tmp = head.next;
            head.next = null;
            stack.push(head);
            head = tmp;
        }
        ListNode root = new ListNode(1);
        ListNode tmp = root;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        return root.next;
    }

}
