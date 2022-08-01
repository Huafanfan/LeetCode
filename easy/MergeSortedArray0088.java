package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/1 21:01
 */
public class MergeSortedArray0088 {
    public static void main(String[] args){
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int m=3;
        int[] nums2 = new int[] {2,5,6};
        int n=3;
        //mergeSort(nums1,m,nums2,n);
        //mergeDoublePointFromStartToFinish(nums1,m,nums2,n);
        mergeDoublePointFromEndToStart(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并后排序
     * 时间复杂度 : O((n+m)log(n+m))。
     * 空间复杂度 : O(1)。
     */
    public static void mergeSort(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针 / 从前往后
     * 时间复杂度 : O(n+m)。
     * 空间复杂度 : O(m)。
     */
    public static void mergeDoublePointFromStartToFinish(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);

        int p1=0;
        int p2=0;

        int i=0;
        while (p1<m&&p2<n){
            nums1[i++] = nums1_copy[p1]<nums2[p2]?nums1_copy[p1++]:nums2[p2++];
        }
        if(p1<m){
            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if(p2<n){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }
    }

    /**
     * 双指针 / 从后往前
     * 时间复杂度 : O(n+m)。
     * 空间复杂度 : O(1)。
     */
    public static void mergeDoublePointFromEndToStart(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0))
        {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
