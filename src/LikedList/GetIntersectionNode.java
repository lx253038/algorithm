package LikedList;

/**
 * @author LX
 * @date 2018-11-23 15:21
 */
/*��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
        ���磬��������������ڽڵ� c1 ��ʼ�ཻ��
        A:             a1 �� a2
                                �K
                                c1 �� c2 �� c3
                                �J
        B:       b1 �� b2 �� b3
ע�⣺  �����������û�н��㣬���� null.
        �ڷ��ؽ���������������뱣��ԭ�еĽṹ��
        �ɼٶ���������ṹ��û��ѭ����
        ���������� O(n) ʱ�临�Ӷȣ��ҽ��� O(1) �ڴ档*/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != null && q != null) {
            p = p.next;
            q = q.next;
        }
        while (p != null) {
            p = p.next;
            headA = headA.next;
        }
        while (q != null) {
            q = q.next;
            headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
