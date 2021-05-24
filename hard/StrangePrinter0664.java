package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/24 11:22
 */
public class StrangePrinter0664 {
    public int strangePrinter(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i=length-1; i>=0; i--){
            dp[i][i] = 1;
            System.out.println(dp[i][i] + " i=" + i + "j=" + i);
            for (int j=i+1; j<length; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                }
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k=i; k<j; k++){
                        min = Math.min(min, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = min;
                }
                System.out.println(dp[i][j] + " i=" + i + "j=" + j);
            }
        }
        return dp[0][length-1];
    }

    public static void main(String[] args) {
        StrangePrinter0664 strangePrinter0664 = new StrangePrinter0664();
        System.out.println(strangePrinter0664.strangePrinter("aba"));
    }
}
