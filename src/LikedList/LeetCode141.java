package LikedList;

import java.util.HashSet;

/**
 * @Author LX
 * @Date 2020/8/19 21:29
 * @Description ����һ�������ж��������Ƿ��л���
 * <p>
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
 * ���룺head = [3,2,0,-4], pos = 1
 * �����true
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
