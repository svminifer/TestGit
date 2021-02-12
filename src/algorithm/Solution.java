package algorithm;

/**
 * @author kaboso
 * @date 2021/2/12 22:30
 */
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    /**
     * 计算链表的长度
     *
     * @param head
     * @return
     */
    public int linkedLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    /**
     * 翻转链表 迭代版
     *
     * @param head
     * @return null 1-2-3-4-5-null
     * 5-4-3-2-1-null
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode node = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        return node;
    }

    /**
     * 翻转链表 递归版
     *
     * @param head
     * @return 递归到最后节点，再一一进行反转，通过改变其引用来达到反转目的
     */
    public ListNode reList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newList = reList(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;

        return newList;

    }

    /**
     * 链表中的节点每k个一组翻转
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode dummy =new ListNode(0);
        dummy.next=head;

        //都指向一个初始头节点
        ListNode pre=dummy;
        ListNode end=dummy;
        while(end.next !=null){
            //-----------------不满k个则不翻转-------------------
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null)
                break;
            //--------------------------------------------------

            /** 不满k个则也翻转
             for (int i = 0; i < k; i++) {
             if (end.next == null) break;
             end = end.next;
             }
             **/

            ListNode start=pre.next;//临时存储k个节点的头节点
            ListNode next=end.next;//临时存储k个节点的尾节点
            end.next=null;//断开k个节点之后的节点
            pre.next=reverse(start);//反转k个节点
            start.next=next;//反转k个节点之后把后面节点接上

            pre=start;//前面k个节点反转之后，则重新以反转之后的尾节点为头
            end=pre;
        }
        return dummy.next;



    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        Solution s = new Solution();
        ListNode node = s.reverseKGroup(head1, 2);//链表中的节点每k个一组翻转
//        ListNode node = s.reverseList(head1);//反转链表 迭代版
//        ListNode node = s.reList(head1);//反转链表 迭代版

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
