package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/13 11:15
 */
public class Lcof19 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //s 的前 i 个和 p 的前 j 个能否匹配
        boolean[][] isMatch = new boolean[n+1][m+1];
        for (int i=0; i<=n; i++){
            for (int j=0; j<=m; j++){
                if (j==0){
                    isMatch[i][j] = (i == 0);
                }
                else {
                    if (p.charAt(j-1) != '*'){
                        if (i>0&&(s.charAt(i - 1)==p.charAt(j - 1)||p.charAt(j - 1) == '.')){
                            isMatch[i][j] = isMatch[i-1][j-1];
                        }
                    }
                    else {
                        if (j>=2){
                            isMatch[i][j] |= isMatch[i][j-2];
                        }
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            isMatch[i][j] |= isMatch[i - 1][j];
                        }
                    }
                }
            }
        }
        return isMatch[n][m];
    }

    public static void main(String[] args) {
        Lcof19 lcof19 = new Lcof19();
        System.out.println(lcof19.isMatch("aa", "a"));
    }
}
