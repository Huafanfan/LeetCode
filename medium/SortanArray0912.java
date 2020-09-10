package medium;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/9 16:28
 */
public class SortanArray0912 {
    public static void main(String[] args) {
        SortanArray0912 sortanArray0912 = new SortanArray0912();
        int[] nums = new int[]{5,1,1,2,0,0,6,7,6,5,4,23,1,3,56};
        sortanArray0912.sortArrayQuick(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * 插入排序：稳定排序，在接近有序的情况下，表现优异
     * 时间复杂度：O(N^2) 最好可以到达O(N)
     * 空间复杂度：O(1)，使用到常数个临时变量。
     *
     * @param nums
     * @return
     */
    public int[] sortArrayInsert(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }

    private static final int INSERTION_SORT_THRESHOLD = 7;

    /**
     * 归并排序
     * 时间复杂度：O(NlogN)，这里 N 是数组的长度；
     * 空间复杂度：O(N)，辅助数组与输入数组规模相当。
     * @param nums
     * @return
     */
    public int[] sortArrayMerge(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    /**
     * 对数组 nums 的子区间 [left, right] 进行归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     */
    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertSort(nums, left, right);
            return;
        }
        int mid = left + (right + left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    public void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     * @param nums
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @param temp  全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            //前一半便利完后直接后一半
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k] = temp[i];
                i++;
            } else {
                // temp[i] > temp[j]
                nums[k] = temp[j];
                j++;
            }
        }
    }


    private static final Random RANDOM = new Random();

    /**
     * 基本快速排序
     * 时间复杂度：O(NlogN)，这里 NN 是数组的长度；
     * 空间复杂度：O(logN)，这里占用的空间主要来自递归函数的栈空间。
     * @param nums
     * @return
     */
    public int[] sortArrayQuick(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertSort(nums, left, right);
            return;
        }

        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        // 基准值
        int pivot = nums[left];
        int lt = left;
        // 循环不变量：
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) >= pivot
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 时间复杂度：O(NlogN)，这里 N 是数组的长度；
     * 空间复杂度：O(1)。
     * @param nums
     * @return
     */
    public int[] sortArrayHeap(int[] nums) {
        int len = nums.length;
        // 将数组整理成堆
        heapify(nums);

        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i);
        }
        return nums;
    }

    /**
     * 将数组整理成堆（堆有序）
     *
     * @param nums
     */
    private void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    /**
     * @param nums
     * @param k    当前下沉元素的下标
     * @param end  [0, end] 是 nums 的有效部分
     */
    private void siftDown(int[] nums, int k, int end) {
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
