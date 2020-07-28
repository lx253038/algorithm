package LikedList;

/**
 * @Author LX
 * @Date 2020/7/28 21:03
 * @Description ɾ�������е��ڸ���ֵ val �����нڵ㡣
 * ʾ��:
 * ����: 1->2->6->3->4->5->6, val = 6
 * ���: 1->2->3->4->5
 */
public class LeetCode203 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(6);


        ListNode listNode = new LeetCode203().removeElements(node, 2);
        System.out.println(listNode);
    }

    //ͷ��㵥���ж�
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode root = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return root;
    }

    //�������ͷ���
    public ListNode removeElements2(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        head = root;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return root.next;
    }
}
