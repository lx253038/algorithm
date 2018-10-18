package LikedList;

/*��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
        ʾ����
        ���룺1->2->4, 1->3->4
        �����1->1->2->3->4->4
*/

public class CombineTwoLikedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(0);
        ListNode head=dummyHead;
        while (l1!=null||l2!=null){
            if(l1==null){
                dummyHead.next=l2;
                return head.next;
            }
            if(l2==null){
                dummyHead.next=l1;
                return head.next;
            }
            if(l1.val>=l2.val){
                dummyHead.next=l2;
                dummyHead=dummyHead.next;
                l2=l2.next;
            }else{
                dummyHead.next=l1;
                dummyHead=dummyHead.next;
                l1=l1.next;
            }
        }

        return  head.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        CombineTwoLikedList st=new CombineTwoLikedList();
        ListNode result=st.mergeTwoLists(l1,l2);
        StringBuilder res=new StringBuilder();
        res.append("[");
        while (result!=null){
            if(result.next!=null){
                res.append(result.val+",");
            }else{
                res.append(result.val+"]");
            }
            result=result.next;
        }
        System.out.println(res.toString());
    }
}
