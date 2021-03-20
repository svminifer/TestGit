package algorithm;

/**
 * 用于练习、复习
 * @Author kaboso
 * @Date 2021/3/20
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}

public class Main {
    //头插法
    public static ListNode headInsert(int[] vals){
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        for (int i = 0; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            temp=dummy.next;
            node.next=temp;
            dummy.next=node;
        }
        return dummy.next;
    }

    //尾插法
    public static ListNode tailInsert(int[] vals){
        if (vals.length == 0) return null;
        ListNode head=new ListNode(vals[0]);
        ListNode dummy=head;
        for (int i = 1; i < vals.length; i++) {
            dummy.next=new ListNode(vals[i]);
            dummy=dummy.next;
        }
        return head;
    }
    //按序号插入
    //按序号删除
    //按值删除

    //从头到尾打印链表
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
    //从尾到头打印链表
    public static void reprint(ListNode head){
        if(head == null) return;
        reprint(head.next);
        System.out.print(head.val+" ");
    }

    /**
     *      应用场景
     */
    //反转链表 递归
    public static ListNode reList(ListNode head){
        if(head ==null) return null;

        ListNode node=reList(head.next);

        if (node == null) return head;
        ListNode temp=head.next;
        temp.next=head;
        head.next=null;
        return node;
    }
    //反转链表 迭代
    public static ListNode reListFor(ListNode head){
        if(head == null) return null;
        ListNode dummy=new ListNode(0);
        while(head!=null){
            ListNode node=dummy.next;
            ListNode next=head.next;
            dummy.next=head;
            head.next=node;

            head=next;
        }
        return dummy.next;
    }




    public static void main(String[] args){
        int[] vals={1,2,3,4,5,6,7};
        //头插法
        ListNode node=headInsert(vals);
        print(node);

        //尾差法
        ListNode tailInsert = tailInsert(vals);
        print(tailInsert);
//        reprint(tailInsert);

        //反转链表(递归)
        ListNode reNode = reListFor(tailInsert);
        print(reNode);

    }

}
