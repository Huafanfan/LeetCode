package medium;

public class PalindromicSubstrings0647 {

    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        if (len < 1){
            return res;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i=0; i<len; i++){
            dp[i][i] = true;
            res++;
        }
        for (int i=1; i<len; i++){
            for (int j=0; j<i; j++){
                if (s.charAt(j) == s.charAt(i)){
                    if (i - j < 3){
                        dp[j][i] = true;
                        res++;
                    }
                    else {
                        if (dp[j+1][i-1]){
                            dp[j][i] = true;
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean check(String s, int j, int i){
        while (j<=i){
            if (s.charAt(j) == s.charAt(i)){
                j++;
                i--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromicSubstrings0647 palindromicSubstrings0647 = new PalindromicSubstrings0647();
        System.out.println(palindromicSubstrings0647.countSubstrings("aaa"));
    }
}
