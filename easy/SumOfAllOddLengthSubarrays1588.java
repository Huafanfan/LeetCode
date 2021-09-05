package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/4 18:17
 */
public class SumOfAllOddLengthSubarrays1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sum = new int[arr.length + 1];
        for (int i=0; i<arr.length; i++){
            sum[i+1] = arr[i] + sum[i];
        }
        int res = sum[arr.length];
        for (int step = 3; step<=arr.length; step += 2){
            for (int i=step; i<=arr.length; i++){
                res += sum[i] - sum[i - step];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays1588 sumOfAllOddLengthSubarrays1588 = new SumOfAllOddLengthSubarrays1588();
        int[] arr = new int[]{1,4,2,5,3};
        System.out.println(sumOfAllOddLengthSubarrays1588.sumOddLengthSubarrays(arr));
    }
}
