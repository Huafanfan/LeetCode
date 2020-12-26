package draft;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 13:15
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

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
        if (left == right){
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
