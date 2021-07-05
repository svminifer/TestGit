package api;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

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

//        ArrayList<Integer> str=new ArrayList();
//        str.add(1);
//        str.add(null);
//        str.add(3);
//        String string = str.toString();
//        System.out.println(string);

//        int[] array={3,1,2};
//        int i = minNumberInRotateArray(array);
//        System.out.println(i);

//        int[] arrs={1,2,3,3,3,3,4,5};
//        int[] arrs={1,2,3,3,3,3};
//        int i = GetNumberOfKTest(arrs, 3);
//        System.out.println(i);

//

        int[] arr={1,4,6,6,6,2,3};
        int duplicate = findDuplicate(arr);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            int temp=nums[fast];
            fast = nums[temp];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }



    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

    public static int GetNumberOfKTest(int [] array , int k) {
        if(array.length == 0) return 0;
        //左边出现的索引
        int first=getFIndex(array,k);
        //右边出现的索引
        int last=getLIndex(array,k);

        return last-first;
    }

    public static int getFIndex(int[] array,int k){
        int left=0;
        int right=array.length-1;


        while(left<right){
            int mid=left+(right-left)/2;
            if(array[mid] == k){
                right=mid;
            }
            else if(array[mid] > k){
                right =mid;
            }
            else if(array[mid] < k){
                left=mid+1;
            }
        }
        return left;
    }

    public static int getLIndex(int[] array,int k){
        int left=0;
        int right=array.length-1;


        while(left<right){
            int mid=left+(right-left)/2;
            if(array[mid] == k){
                left=mid+1;
            }
            else if(array[mid] > k){
                right =mid;
            }
            else if(array[mid] < k){
                left=mid+1;
            }
        }
        return right;
    }

    public static int GetNumberOfK(int[] array, int k) {
        int lbound = 0, rbound = 0;
        // 寻找上界：k的第一次出现的位置

        //l表示数组左边界 r表示数组右边界
        int l = 0, r = array.length;
        //不越界的情况下遍历
        while (l < r) {
            //二分法：取中位
            int mid = l + (r - l) / 2;
            //中位对应的数 < k 说明k的上界在右边
            //不考虑 = 是因为要左边界
            if (array[mid] < k) {
                //则需要在右边找k的上界
                l = mid + 1;
                //否则，k的上界在左边，则需要在左边找
            } else {
                r = mid;
            }
        }

        lbound = l;
        // 寻找下界：k的最后一次出现的位置
        l = 0;
        r = array.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //考虑 = 是要右边界
            if (array[mid] <= k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        rbound = l;
        return rbound - lbound;
    }

    public static int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}
