package LikedList;

import java.util.Stack;
/*
反转一个单链表。
        示例:
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
*/

public class Reverse {
    public ListNode reverselist(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode twonode = head.next;
        head.next = null;
        while (twonode != null) {
            ListNode temp = twonode.next;
            twonode.next = head;
            head = twonode;
            twonode = temp;
        }
        return head;

        //使用栈实现
       /* Stack<ListNode> nodes = new Stack<>();
        inStack(head, nodes);
        return outStack(nodes);*/
    }

    private void inStack(ListNode head, Stack nodes) {
        if (head == null) {
            return;
        }
        nodes.push(head);
        inStack(head.next, nodes);
    }

    private ListNode outStack(Stack<ListNode> nodes) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        while (!nodes.isEmpty()) {
            dummyHead.next = nodes.pop();
            dummyHead = dummyHead.next;
        }
        dummyHead.next = null;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(9);
        Reverse st = new Reverse();
        ListNode node = st.reverselist(l1);
        System.out.println(node.val);
    }
}
