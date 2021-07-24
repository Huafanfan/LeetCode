package shopee;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 16:13
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
