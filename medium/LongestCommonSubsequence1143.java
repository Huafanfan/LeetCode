package medium;

public class LongestCommonSubsequence1143 {
    //text1 = "abcde", text2 = "ace"
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i=0; i<len1; i++){
            for (int j=0; j<len2; j++){
                if (chars1[i] == chars2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence1143 longestCommonSubsequence1143 = new LongestCommonSubsequence1143();
        System.out.println(longestCommonSubsequence1143.longestCommonSubsequence("abccde","ace"));
    }
}
