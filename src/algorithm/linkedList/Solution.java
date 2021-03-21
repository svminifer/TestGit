package algorithm.linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
     * 头插法
     * 会改变插入顺序，输入1,2,3,4,5 -- 输出5,4,3,2,1
     *
     * @param val
     */
    public void headInsert(int[] val) {
        if (val.length == 0) return;

        ListNode dummy = new ListNode(0);

        for (int i = 0; i < val.length; i++) {
            ListNode head = new ListNode(val[i]);
            head.next = dummy.next;
            dummy.next = head;
        }

        print(dummy.next);

    }

    /**
     * 尾插法
     */
    public void tailInsert(int[] val) {
        ListNode dummy = new ListNode(0);//用于记录头结点位置
        ListNode temp = dummy;
        for (int i = 0; i < val.length; i++) {
            ListNode node = new ListNode(val[i]);
            temp.next = node;
            temp = temp.next;
        }
        print(dummy.next);
    }

    /**
     * 打印链表
     *
     * @param node
     */
    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

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
     * 链表的中间节点
     * 1,2,3,4, 5,6, 7,8,9,10
     * 1,2,3,4, 5, 6,7,8,9
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)  // 长度为奇数
            return slow;
        else
            return slow.next;  // 长度为偶数
    }


    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //双指针 node1一次走一个节点 node2 一次走两个节点
        ListNode p = head;
        ListNode q = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) {
                return true;
            }

        }
        return false;
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //都指向一个初始头节点
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
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

            ListNode start = pre.next;//临时存储k个节点的头节点
            ListNode next = end.next;//临时存储k个节点的尾节点
            end.next = null;//断开k个节点之后的节点
            pre.next = reverse(start);//反转k个节点
            start.next = next;//反转k个节点之后把后面节点接上

            pre = start;//前面k个节点反转之后，则重新以反转之后的尾节点为头
            end = pre;
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

    /**
     * 两个有序的链表合并为一个新链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;

            if (val1 < val2) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null && l2 == null) temp.next = l1;
        if (l1 == null && l2 != null) temp.next = l2;

        return dummy.next;
    }

    /**
     * 顺序解法 O(nk²)
     * 合并k个已排序的链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);
        ListNode head = mergeTwoLists(lists.get(0), lists.get(1));
        for (int i = 2; i < lists.size(); i++) {
            head = mergeTwoLists(head, lists.get(i));
        }
        return head;
    }

    /**
     * 归并解法 O(nlogk)
     * 合并k个已排序的链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsMerge(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.size() - 1);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists, int low, int high) {
        if (low >= high) {
            return lists.get(low);
        }
        int mid = low + (high - low) / 2;
        ListNode l1 = mergeKLists(lists, low, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, high);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
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

    /**
     * 优先队列解法
     * 合并k个已排序的链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsPriorityQueue(ArrayList<ListNode> lists) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            res.next = node;
            res = res.next;

            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return head.next;
    }

    /**
     * 链表中环的入口节点
     *
     * @param head
     * @return 快慢指针实现
     * 两指针相遇时：show走a+b fast走a+b+b+c a=c
     */
    public ListNode detectCycle(ListNode head) {
        ListNode show = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            show = show.next;
            fast = fast.next.next;
            //两指针相遇时：show走a+b fast走a+b+b+c a=c
            //则令show返回起点走a步 fast继续走c步 一起走 相等则得到入口节点
            if (show == fast) {
                show = head;
                while (show != fast) {
                    show = show.next;
                    fast = fast.next;
                }
                return show;
            }
        }
        return null;
    }


    /**
     * 两个链表生成相加链表 反向
     * 数位是反向存放的，也就是个位排在链表首部。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addInList(ListNode l1, ListNode l2) {
        // write code here
        //虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            //相加之和(包含进位的)
            int sum = i + j + carry;
            if (sum >= 10) {
                //carry++;
                //尾插法
                temp.next = new ListNode(sum % 10);
            } else {
                temp.next = new ListNode(sum);
            }
            //更新进位的值
            carry = sum / 10;

            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    /**
     * 两个链表生成相加链表 正向
     * 反转+头插法 / 栈
     *
     * @param l1
     * @param l2
     * @return
     */
     /*
    题目描述
        假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
        给定两个这种链表，请生成代表两个整数相加值的结果链表。
        例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
        示例1
        输入
        [9,3,7],[6,3]
        返回值
        {1,0,0,0}

        937+63=1000
     */
    public ListNode addInListReverse(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        // write code here
        //虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode head = null;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            //相加之和(包含进位的)
            int sum = i + j + carry;
            if (sum >= 10) {
                //carry++;
                //头插法
                head = new ListNode(sum % 10);

            } else {
                head = new ListNode(sum);
            }
            head.next = dummy.next;
            dummy.next = head;
            //更新进位的值
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    /**
     * 判断一个链表是否为回文结构
     *
     * @param head
     * @return
     */
    /*
    题目描述
            给定一个链表，请判断该链表是否为回文结构。
            示例1
            输入
            [1,2,2,1]
            返回值
            true
     */
    public boolean isPail(ListNode head) {
        // write code here
        //中间节点
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mNode = slow.next;
        ListNode node = reverseList(mNode);

        while (node != null) {
            if (node.val != head.val) return false;
            node = node.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 重排链表
     *
     * @param head
     */
    /*
    题目描述
            将给定的单链表 L L： L0→L1→…→L{n-1}→Ln
            重新排序为：L0→Ln →L1→L{n-1}→L2→L{n-2}→…

            要求使用原地算法，不能改变节点内部的值，需要对实际的节点进行交换。
            例如：
            对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.
            40 30 20 10

            1,2,3,4, 5,6, 7,8,9,10
            1,2,3,4, 5,   6,7,8,9
            对于有传入节点的，进行链表的拼接与结合时，不需要声明临时变量保存头节点，因为函数调用结束时，实参仍然是原来的节点地址
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        //找到中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode newHead = reverse(mid);
        while (newHead != null) {
            //交叉合并
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;

            //两链指向对应的下一节点
            head = newHead.next;
            newHead = temp;
        }
    }

    /**
     * 重排链表 ArrayList解决方案
     * head有n个节点 则空间O(n)
     *
     * @param head
     */
    public void recorderListArrayList(ListNode head) {
        if (head == null)
            return;
        List<ListNode> list = new ArrayList<>();   //  ArrayList为线性表
        // 将 链表的每一个节点依次 存进ArrayList中
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 两个指正依次从前 后进行遍历取元素
        int i = 0, j = list.size() - 1;
        while (i < j) {
            //  eg:  1->2->3->4
            // 前面的节点的下一个节点指向最后的节点
            list.get(i).next = list.get(j);  //  即 1->4
            i++;  // 此时 i++ 则此时 list.get(i) 为原来前面节点的下一个节点   即节点2
            if (i == j) // 若 链表长度为偶数的情况下 则会提前相遇，此时已达到题目要求，直接终止循环
                break;
            list.get(j).next = list.get(i);   // 4->2
            // 此时刚刚的例子则变为  1->4->2->3
            j--;
        }
        list.get(i).next = null;  // 最后一个节点的下一个节点为null
    }

    /**
     * 链表中倒数第k个结点
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode slow = pHead, fast = pHead;
        for (int i = 0; i < k; i++){
            if (fast == null) return fast;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除链表的倒数第n个节点并返回链表的头指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head ==null) return head;
        //考虑到删除倒数第n个节点有可能是头节点，这种情况下，则必须新建的临时头结点替代
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;

        int i=0;
        while(fast!=null && i<n+1){
            fast=fast.next;
            i++;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;

    }

    /**
     * 单链表的排序 O（nlogn）
     * @param head
     * @return
     */
    public static ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null)
            return head;
        //使用快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //分割为两个链表
        ListNode newList = slow.next;
        slow.next = null;
        //将两个链表继续分割
        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);

        ListNode lhead = new ListNode(-1);
        ListNode res = lhead;
        //归并排序
        while(left != null && right != null){
            if(left.val < right.val){
                lhead.next = left;
                left = left.next;
            }else{
                lhead.next = right;
                right = right.next;
            }
            lhead = lhead.next;
        }
        //判断左右链表是否为空
        lhead.next = left!=null?left:right;
        return res.next;
    }



    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        s.reorderList(head1);
        s.print(head1);
        //链表的中间节点
//        ListNode node = s.middleNode(head1);
//        s.print(node);

        //判断是否有环
//        head5.next = head3;
//        ListNode node = s.reverseKGroup(head1, 2);//链表中的节点每k个一组翻转
//        ListNode node = s.reverseList(head1);//反转链表 迭代版
//        ListNode node = s.reList(head1);//反转链表 迭代版
//        boolean result = s.hasCycle(head1);//判断是否有环
//        System.out.println(result);


//        //链表相加
//        ListNode head1 = new ListNode(9);
//        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(7);
//        ListNode head4 = new ListNode(6);
//        ListNode head5 = new ListNode(3);
//        head1.next = head2;
//        head2.next = head3;
//
//        head4.next = head5;
//
//        ListNode node = s.addInListReverse(head1, head4);
//
//        s.print(node);


//        int[] val = {1, 2, 3, 4, 5};
//        s.headInsert(val);//头插法
//        s.tailInsert(val);//尾插法

    }
}
