package LikedList;

/*给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

        你可以假设除了数字 0 之外，这两个数字都不会以零开头。

        示例：

        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
*/

public class SumTwoLikedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr=dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            dummyHead.next = new ListNode(sum % 10);
            dummyHead = dummyHead.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            dummyHead.next = new ListNode(carry);
        }
        return curr.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
        l1.next=new ListNode(7);
        l1.next.next=new ListNode(2);

        ListNode l2=new ListNode(3);
        l2.next=new ListNode(1);
        l2.next.next=new ListNode(6);

        SumTwoLikedList st=new SumTwoLikedList();
        ListNode result=st.addTwoNumbers(l1,l2);
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
