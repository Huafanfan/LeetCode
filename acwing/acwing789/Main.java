package acwing.acwing789;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/1 12:33
 */
public class Main {
    /**
     * 二分查找就是保证答案被区间覆盖
     * 二分一定有解
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
        while (m-- > 0){
            int x = in.nextInt();
            int l = 0, r = n-1;
            // 找到第一个小于等的，所以 >= x ，抛弃右边，往左走。
            while (l < r){
                int mid = l + r >> 1;
                if (nums[mid] >= x){
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] != x){
                System.out.println("-1 -1");
            } else {
                System.out.print(l + " ");
                l = 0;
                r = n-1;
                // 找到第一个大于等于的，所以 <= x ，抛弃左边，往右走。
                while (l < r){
                    int mid = l + r + 1 >> 1;
                    if (nums[mid] <= x){
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                System.out.println(l);
            }
        }
    }
}
