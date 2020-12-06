package easy.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/6 10:02
 */
public class IsSubsequence0392 {
    public boolean isSubsequence(String s, String t) {
        int curIndex = 0;
        for (int i=0; i<s.length(); i++) {
            boolean isMatch = false;
            for (int j = curIndex; j<t.length(); j++){
                if (t.charAt(j) == s.charAt(i)){
                    curIndex = j+1;
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch){
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public boolean isSubsequence3(String s, String t) {
        int n = s.length(), m = t.length();
        //f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置
        int[][] f= new int[m+1][26];
        for (int i=0; i<26; i++) {
            f[m][i] = m;
        }
        for (int i=m-1; i >= 0; i--) {
            for (int j=0; j<26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                }
                else {
                    f[i][j] = f[i+1][j];
                }
            }
        }
        int add = 0;
        for (int i=0; i<n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence0392 isSubsequence0392 = new IsSubsequence0392();
        System.out.println(isSubsequence0392.isSubsequence3("abc", "ahbbgdc"));
    }
}
