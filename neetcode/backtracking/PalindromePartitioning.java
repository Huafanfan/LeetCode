package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
//    List<List<String>> ans = new ArrayList<>();
//    public List<List<String>> partition(String s) {
//        backTrace(s, 0, new ArrayList<>());
//        return ans;
//    }
//
//    public void backTrace(String s, int index, List<String> list){
//        if (index == s.length()){
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 1; i + index <= s.length(); i++){
//            String sub = s.substring(index, index + i);
//            if (ifPalindrome(sub)){
//                list.add(sub);
//                backTrace(s, index + i, list);
//                list.remove(list.size()-1);
//            }
//        }
//    }
//
//    public  boolean ifPalindrome(String s){
//        int left = 0, right = s.length() - 1;
//        while (left < right){
//            if (s.charAt(left++) != s.charAt(right--)){
//                return false;
//            }
//        }
//        return true;
//    }
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab"));
    }
}
