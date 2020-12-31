package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/23 13:57
 */
public class LongestPalindromicSubstring0005 {
    /**
     * 暴力枚举
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s.length()<2){
            return s;
        }
        int maxLen=1;
        int begin=0;
        for (int i=0; i<s.length()-1; i++){
            for(int j=i+1; j<s.length(); j++){
                if((j-i+1)>maxLen){
                    boolean flag=true;
                    int left = i,right=j;
                    while (left<right){
                        if (s.charAt(left)!=s.charAt(right)){
                            flag=false;
                            break;
                        }
                        left++;
                        right--;
                    }
                    if(flag){
                        maxLen = j-i+1;
                        begin=i;
                    }
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1, begin = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                begin = i-(maxLen-1)/2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        //R-L+1-2 不包括最后的L 和 R
        return R - L - 1;
    }

    /**
     * 动态规划 
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        int len=s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1, begin = 0;
        boolean[][] dp=new boolean[len][len];
        for (int i=0; i<len; i++){
            dp[i][i]=true;
        }
        for (int j=1; j<len; j++){
            for (int i=0; i<j; i++){
                if (s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }
                else{
                    //(j-1)-(i+1)+1<2 子串长度小于2时,也就是串长度为2或者3时，j-i+1<4，不用检查子串
                    if(j-i<3){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
