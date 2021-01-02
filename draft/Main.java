package draft;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 13:15
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        int[] a = new int[]{1,3,5,2,2};
        int k = 4;
        main.quickSort(a, 0, a.length-1, k);
        System.out.println(a[k-1]);
        int[][] m = new int[][]{{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(main.minPathSum(m));

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        main.reverseBetween(node1, 2, 4);
        System.out.println(node1);
    }

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int _val){
            val = _val;
        }
    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummp = new ListNode(-1);
        dummp.next = head;
        ListNode newHead = dummp;
        ListNode tail = dummp;
        while(m>1){
            newHead = newHead.next;
            m--;
        }
        while(n>0){
            tail = tail.next;
            n--;
        }
        ListNode start = newHead.next;
        newHead.next = null;

        ListNode end = tail;
        newHead.next = tail.next;
        end.next = null;

        while(start!=null){
            ListNode tmp = start.next;
            start.next = newHead.next;
            newHead.next = start;
            start = tmp;
        }
        return dummp.next;

    }

    public int minPathSum (int[][] matrix) {
        // write code here
        for(int i=1; i<matrix.length; i++){
            matrix[0][i] += matrix[0][i-1];
        }
        for(int i=1; i<matrix.length; i++){
            matrix[i][0] += matrix[i-1][0];
            for(int j=1; j<matrix[0].length; j++){
                matrix[i][j] += Math.min(matrix[i-1][j] , matrix[i][j-1]);
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }

    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int left = 0;
        int right = n-1;
        int mid = left + (right - left)/2;
        while(left<right){
            if(a[mid]>=v){
                right = mid;
            }
            else{
                left = mid + 1;
            }
            mid = left + (right - left)/2;
        }
        if(a[mid] == v){
            return mid + 1;
        }
        else{
            return n + 1;
        }
    }

    public int[] sortArrayInsert(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++){
            int tmp = nums[i];
            int j = i;
            while (j>0&&nums[j-1] > tmp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }

    public int[] sortArrayMerge(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        mergeSort(nums, 0, n-1, tmp);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right, int[] tmp){
        if (left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid+1, right, tmp);
        if (nums[mid] < nums[mid+1]){
            return;
        }
        mergeTowArrays(nums, left, mid, right, tmp);
    }

    public void mergeTowArrays(int[] nums, int left, int mid, int right, int[] tmp){
        System.arraycopy(nums, left, tmp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k=left; k<=right; k++){
            if (i == mid + 1){
                nums[k] = tmp[j++];
            }
            else if (j == right + 1){
                nums[k] = tmp[i++];
            }
            else if (tmp[i] <= tmp[j]){
                nums[k] = tmp[i++];
            }
            else {
                nums[k] = tmp[j++];
            }
        }
    }

    public int[] sortArrayQuick(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int index = partion(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    public void quickSort(int[] arr, int left, int right, int k){
        if(left >= right){
            return;
        }
        int index = partion(arr, left, right);
        int count = index - left + 1;
        if(count == k){
            return;
        }
        else if(k<count){
            quickSort(arr, left, index - 1, k);

        }
        else{
            quickSort(arr, index + 1, right, k - count);
        }
    }

    public int partion(int[] nums, int left, int right){
        int randomIndex  = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        int tmp = nums[left];
        int lt = left;
        for (int i=left+1; i<=right; i++){
            if (nums[i] < tmp){
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    public void swap(int[] nums , int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int[] sortArrayHeap(int[] nums) {
        int len = nums.length;
        heapify(nums);
        for (int i = len - 1; i >= 1; ) {
            swap(nums, 0, i);
            i--;
            siftDown(nums, 0, i);
        }
        return nums;
    }

    public void heapify(int[] nums){
        int len  = nums.length;
        for (int i = (len-1)/2 ; i>=0; i++){
            siftDown(nums, i, len - 1);
        }
    }

    public void siftDown(int[] nums, int k, int end){
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            k = j;
        }
    }
}
