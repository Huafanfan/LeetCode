package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/13 11:15
 */
public class Lcof19 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //s 的前 i 个和 p 的前 j 个能否匹配
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i=0; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (p.charAt(j-1) != '*'){
                    if (isMatch(s, p, i, j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
                else {
                    f[i][j] = f[i][j-2];
                    if (isMatch(s, p, i, j-1)){
                        f[i][j] |= f[i-1][j];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean isMatch(String s, String p, int i, int j){
        if (i==0){
            return false;
        }
        if (p.charAt(j-1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        Lcof19 lcof19 = new Lcof19();
        System.out.println(lcof19.isMatch("aa", "a"));
    }
}
