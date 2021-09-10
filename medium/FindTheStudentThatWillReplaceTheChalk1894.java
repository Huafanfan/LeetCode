package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/10 08:59
 */
public class FindTheStudentThatWillReplaceTheChalk1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        k %= sum;
        for (int i=0; i<chalk.length; i++){
            if (k >= chalk[i]){
                k -= chalk[i];
            }
            else {
                return i;
            }
        }
        return 0;
    }

    public int chalkReplacer2(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) {
            return 0;
        }
        for (int i = 1; i < n; ++i) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) {
                return i;
            }
        }

        k %= chalk[n - 1];
        return binarySearch(chalk, k);
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
