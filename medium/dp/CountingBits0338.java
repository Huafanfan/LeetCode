package medium.dp;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/5 11:45
 */
public class CountingBits0338 {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i=0; i<=num; i++){
            int cur = i;
            int count = 0;
            while (cur!=0) {
                cur &= cur-1;
                count++;
            }
            result[i] = count;
        }
        return result;
    }

    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            // reset i
            i = 0;
            // b = 2b
            b <<= 1;
        }
        return ans;
    }

    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
        {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public int[] countBits4(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        CountingBits0338 countingBits0338 = new CountingBits0338();
        System.out.println(Arrays.toString(countingBits0338.countBits2(7)));
    }
}
