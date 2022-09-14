package easy;

import java.util.Arrays;

/**
 * @author yifan.zhangyf
 * @date 2022/9/14 9:47 PM
 */
public class MeanOfArrayAfterRemovingSomeElements1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int deleteNum = (int) (length * 0.05);
        int sum = 0;
        for (int i=deleteNum; i<length-deleteNum; i++){
            sum += arr[i];
        }
        return 1.0 * sum / (length - 2 * deleteNum);
    }
}
