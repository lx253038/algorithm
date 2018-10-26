package LikedList;

/*����һ������ͷ��� head �ķǿյ���������������м��㡣
        ����������м��㣬�򷵻صڶ����м��㡣
        ʾ�� 1��
        ���룺[1,2,3,4,5]
        ��������б��еĽ�� 3 (���л���ʽ��[3,4,5])
        ���صĽ��ֵΪ 3 �� (����ϵͳ�Ըý�����л������� [3,4,5])��
        ע�⣬���Ƿ�����һ�� ListNode ���͵Ķ��� ans��������
        ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, �Լ� ans.next.next.next = NULL.*/

public class MiddleNode {
    public ListNode middleNodes(ListNode head) {
        //ʹ�ö��д洢
/*        Queue<ListNode> queue=new LinkedList<>();
        while (head!=null){
            queue.add(head);
            head=head.next;
        }

        int size=queue.size();
        for (int i=0;i<size/2;i++){
            queue.remove();
        }
        return queue.peek();
    */
        //ʹ������洢
        ListNode[] array = new ListNode[100];
        int count = 0;
        while (head != null) {
            array[count++] = head;
            head = head.next;
        }
        return array[count / 2];
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(9);
        MiddleNode st = new MiddleNode();

        System.out.println(st.middleNodes(l1).val);
    }
}
