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

    //1.从尾到头打印链表
    public static void reprint(ListNode head){
        if(head == null) return;
        reprint(head.next);
        System.out.print(head.val+" ");
    }

    //2.从头到尾打印链表
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }




    /**
     *      应用场景
     */
    //反转链表 递归
    public static ListNode reList(ListNode head){
        if(head ==null) return null;

        ListNode node=reList(head.next);

        if (node == null) return head;
        ListNode temp=head.next;//必须使用临时变量temp保存该节点地址，否则head.next=head会导致两个节点的下一个节点相互指向对方
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
        int[] vals={1,2,3,4,5};
        int[] vals1={1,2,4,7};
        int[] vals2={1,2,6,6,7};
        //头插法
        ListNode node=headInsert(vals);
        print(node);

        //尾差法
        ListNode tailInsert = tailInsert(vals);
        print(tailInsert);
//        reprint(tailInsert);

        //反转链表(递归)
//        ListNode reNode = reListFor(tailInsert);
//        print(reNode);

        ListNode l1 = tailInsert(vals1);
        ListNode l2 = tailInsert(vals2);
        merge(l1,l2);

    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }

    }

    public static  ListNode reverseKGroup(ListNode head, int k) {

        if(head ==null) return head;

        ListNode dummy=new ListNode(0);
        ListNode dNode=dummy;

        while(head!=null){
            ListNode pHead=head;
            for(int i=1;i<=k-1&&pHead!=null;i++){
                pHead=pHead.next;
            }
            if(pHead == null){
                dNode.next=head;
                break;
            }
            ListNode temp=pHead.next;//尾部节点

            pHead.next=null;//断链表
            ListNode reNode=reList(pHead);//反转

            dNode.next=reNode;//将反转后的链表加入
            dNode=dNode.next;

            head=temp;
        }
        return dummy.next;
    }
    /**
       分步走
       1.找到中间节点
       2.反转
       3.重新排列（插入）

       中间节点有特殊情况，需要区分链表长为奇、偶数的情况下，中间节点的位置，前链表和后链表要完全断开，需要对尾节点赋值为null

    */
    public static void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        ListNode pre=null;
        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=null;
        if(fast !=null){
            //表长为奇
            mid=slow.next;
            slow.next=null;
        }
        else{
            //表长为偶
            mid=slow;
            pre.next=null;
        }

        //反转
        ListNode reNode=reList(mid);

        //重新排列

        while(reNode!=null){
            ListNode temp=head.next;
            head.next=reNode;

            ListNode next=reNode.next;

            reNode.next=temp;

            head=temp;
            reNode=next;
        }
    }

    /**
     * 反转链表2
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return head;

        int i=1,j=0;
        ListNode pHead=null;
        ListNode tail=null;
        ListNode dummy=new ListNode(0);
        ListNode newNode=dummy;
        ListNode pre=null;
        dummy.next=head;
        while(dummy!=null && dummy.next!=null && j<=right){
            if(i == left){
                pre=dummy;
                pHead=dummy.next;
            }
            if(j == right){
                tail=dummy.next;
                dummy.next=null;
                break;
            }

            dummy=dummy.next;
            i++;
            j++;
        }
        ListNode reNode=reList(pHead);
        pre.next=reNode;

        pHead.next=tail;

        return newNode.next;


    }


}
