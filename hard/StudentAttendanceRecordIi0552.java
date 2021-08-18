package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/8/18 09:03
 */
public class StudentAttendanceRecordIi0552 {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 1;
        for (int i=1; i<=n; i++){
            //以P结尾
            for (int j=0; j<=1; j++){
                for (int k=0; k<=2; k++){
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % MOD;
                }
            }
            //以A结尾
            for (int k=0; k<=2; k++){
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % MOD;
            }

            //以L结尾
            for (int j=0; j <=1; j++) {
                for (int k=1; k<=2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }

    public int checkRecord2(int n) {
        final int MOD = 1000000007;
        //这里是第一天的结果
        long a00 = 1;
        long a01 = 1;
        long a02 = 0;
        long a10 = 1;
        long a11 = 0;
        long a12 = 0;
        for (int i=2; i<=n; i++){
            long b00 = (a00 + a01 + a02) % MOD;
            long b01 = a00;
            long b02 = a01;
            long b10 = (a00 + a01 + a02 + a10 + a11 + a12) % MOD;
            long b11 = a10;
            long b12 = a11;
            a00 = b00;
            a01 = b01;
            a02 = b02;
            a10 = b10;
            a11 = b11;
            a12 = b12;
        }
        return (int) ((a00 + a01 + a02 + a10 + a11 + a12) % MOD);
    }
}
