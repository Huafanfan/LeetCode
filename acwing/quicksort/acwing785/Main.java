package acwing.quicksort.acwing785;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/29 16:48
 */
public class Main {
    /**
     * 快排 - 分治
     * 确定分界点
     * 调整区间
     * 递归处理左右两段
     */

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        quickSort(nums, 0, n-1);

        for (int i=0; i<n; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void  quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        //i,j指向两侧，这里可以left，right或者（left+right）/ 2
        int x = nums[left], i = left - 1, j = right + 1;
        while (i < j){
            do {
                i++;
            }while (nums[i] < x);

            do {
                j--;
            }while (nums[j] > x);

            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // 之前选left，这里就使用j，选right，就使用i，否则会有边界问题，死循环。
        quickSort(nums, left, j);
        quickSort(nums, j+1, right);
//        quick_sort(nums, left, i-1);
//        quick_sort(nums, i, right);
    }
}