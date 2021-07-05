package algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author kaboso
 * @Date 2021/3/22
 */

class TreeNode {
    int val ;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val){
        this.val=val;
    }
}


public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        int[][] ints = threeOrders(root);
        Arrays.toString(ints);
    }
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public static int[][] threeOrders(TreeNode root) {
        // write code here
        ArrayList<Integer> pre = new ArrayList();
        ArrayList<Integer> mid = new ArrayList();
        ArrayList<Integer> tail = new ArrayList();
        ArrayList<ArrayList> all = new ArrayList();
        pre(root, pre);
        mid(root, mid);
        tail(root, tail);

        all.add(pre);
        all.add(mid);
        all.add(tail);

        int[][] res = new int[3][];

        for (int i = 0; i < all.size(); i++) {
            ArrayList arrayList =  all.get(i);
            int[] temp=new int[arrayList.size()];
            for (int j = 0; j < arrayList.size(); j++) {
                temp[j]= (int) arrayList.get(j);
            }
            res[i]=temp;
        }

        return res;
    }

    public static  void pre(TreeNode root, ArrayList arr) {
        if (root == null) return;

        arr.add(root.val);
        pre(root.left, arr);
        pre(root.right, arr);
    }

    public static void mid(TreeNode root, ArrayList arr) {
        if (root == null) return;
        pre(root.left, arr);
        arr.add(root.val);
        pre(root.right, arr);
    }

    public static void tail(TreeNode root, ArrayList arr) {
        if (root == null) return;
        pre(root.left, arr);
        pre(root.right, arr);
        arr.add(root.val);
    }
}
