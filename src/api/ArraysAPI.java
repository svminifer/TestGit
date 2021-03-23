package api;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author kaboso
 * @date 2021/2/12 21:21
 * Arrays工具类练习
 */
public class ArraysAPI {
    public static void main(String[] args) {
        //复制数组到新的变量中
//        int[] arr={0,1,2,3,4,5,6};
//        int[] range = Arrays.copyOfRange(arr, 10, arr.length);
//        System.out.println(Arrays.toString(range));

        ArrayList<Integer> str=new ArrayList();
        str.add(1);
        str.add(null);
        str.add(3);
        String string = str.toString();
        System.out.println(string);


    }
}
