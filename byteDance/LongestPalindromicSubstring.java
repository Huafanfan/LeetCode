package byteDance;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len=s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1, begin = 0;
        boolean[][] dp=new boolean[len][len];
        for (int i=0; i<len; i++){
            dp[i][i]=true;
        }
        //遍历所有字串，i表示左节点，j表示右节点
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
