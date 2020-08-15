package LikedList;

/**
 * @Author LX
 * @Date 2020/8/13 20:09
 * @Description ����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������?û���ظ�����?�����֡�
 * ʾ��?1:
 * ����: 1->2->3->3->4->4->5
 * ���: 1->2->5
 */
public class LeetCode82 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);

        new LeetCode82().deleteDuplicates(root);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        head = root;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                ListNode inNode = head.next.next;
                ListNode tmp = null;
                while (inNode.next != null) {
                    if (inNode.val != inNode.next.val) {
                        tmp = inNode.next;
                        break;
                    }
                    inNode = inNode.next;
                }
                head.next = tmp;
            } else {
                head = head.next;
            }
        }
        return root.next;
    }
}
