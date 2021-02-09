package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/9 20:51
 */
public class LongestPalindromicSubstring0005 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean [][] dp = new boolean[len][len];
        for (int i=0; i<len; i++){
            dp[i][i] = true;
        }
        int start = 0;
        int resLen = 1;
        for (int i = 1; i<len; i++){
            for (int j = 0; j<i; j++){
                if (chars[j] == chars[i]){
                    if (i - j + 1 < 3){
                        dp[j][i] = true;
                    }
                    else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                    if (dp[j][i] && i - j + 1 > resLen){
                        start = j;
                        resLen = i - j + 1;
                    }
                }
                else {
                    dp[j][i] = false;
                }
            }
        }
        return s.substring(start, start + resLen);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring0005 longestPalindromicSubstring0005 = new LongestPalindromicSubstring0005();
        System.out.println(longestPalindromicSubstring0005.longestPalindrome("aacabdkacaa"));
    }
}
