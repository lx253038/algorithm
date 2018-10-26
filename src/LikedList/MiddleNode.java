package LikedList;

/*给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
        如果有两个中间结点，则返回第二个中间结点。
        示例 1：
        输入：[1,2,3,4,5]
        输出：此列表中的结点 3 (序列化形式：[3,4,5])
        返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
        注意，我们返回了一个 ListNode 类型的对象 ans，这样：
        ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.*/

public class MiddleNode {
    public ListNode middleNodes(ListNode head) {
        //使用队列存储
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
        //使用数组存储
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
