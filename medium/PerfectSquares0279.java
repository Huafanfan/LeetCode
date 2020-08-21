package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/21 10:27
 */
public class PerfectSquares0279 {
    public static void main(String[] args) {
        PerfectSquares0279 perfectSquares0279 = new PerfectSquares0279();
        System.out.println(perfectSquares0279.numSquaresGreedyBFS(13));
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquareIndex = (int)Math.sqrt(n)+1;
        int[] squareNumber = new int[maxSquareIndex];
        for (int i=1; i<maxSquareIndex; i++){
            squareNumber[i] = i*i;
        }
        for (int i=1; i<=n; i++){
            for (int s=1; s<maxSquareIndex; s++){
                if (i<squareNumber[s]){
                    break;
                }
                dp[i] = Math.min(dp[i],dp[i-squareNumber[s]]+1);
            }
        }
        return dp[n];
    }

    Set<Integer> squareNums = new HashSet<Integer>();
    /**
     * 贪心算法
     * @param n
     * @return
     */
    public int numSquaresGreedy(int n) {
        this.squareNums.clear();
        for (int i=1; i*i<=n; i++){
            this.squareNums.add(i*i);
        }
        int count = 1;
        for (; count<=n; count++){
            if (isDividedBy(n,count)){
                return count;
            }
        }
        return count;
    }
    public boolean isDividedBy(int n, int count){
        if (count==1){
            return squareNums.contains(n);
        }
        for (int num: squareNums){
            if (isDividedBy(n-num,count-1)){
                return true;
            }
        }
        return false;
    }

    public int numSquaresGreedyBFS(int n) {
        ArrayList<Integer> squareNums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            squareNums.add(i * i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> nextQueue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : squareNums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        nextQueue.add(remainder - square);
                    }
                }
            }
            queue = nextQueue;
        }
        return level;
    }

    protected boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public int numSquaresMath(int n) {
        // four-square and three-square theorems. n = 4^{k}(8m+7)
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        if (this.isSquare(n)) {
            return 1;
        }
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i)) {
                return 2;
            }
        }
        // bottom case of three-square theorem.
        return 3;
    }
}
