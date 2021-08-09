package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber0313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.add(1L);
        int ugly = 0;
        for (int i=0; i<n; i++){
            long cur = heap.poll();
            ugly = (int) cur;
            for (int prime : primes) {
                long next = prime * cur;
                if (seen.add(next)){
                    heap.add(next);
                }
            }
        }
        return ugly;
    }
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int len = primes.length;
        int[] pointers = new int[len];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[len];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < len; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        SuperUglyNumber0313 superUglyNumber0313 = new SuperUglyNumber0313();
        int[] primes = new int[]{2,7,13,19};
        System.out.println(superUglyNumber0313.nthSuperUglyNumber(12, primes));
    }
}
