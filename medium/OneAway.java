package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/13 11:39
 */
public class OneAway {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if (m - n == 1){
            return change(first, second);
        } else if (n - m == 1){
            return change(second, first);
        } else if (m == n){
            boolean diff  = false;
            for (int i=0; i<m; i++){
                if (first.charAt(i) != second.charAt(i)){
                    if (!diff){
                        diff = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean change(String longStr, String shortStr){
        int i=0, j=0;
        while (i < shortStr.length() && j < longStr.length()){
            if (shortStr.charAt(i) == longStr.charAt(j)){
                i++;
            }
            j++;
            if (j - i > 1){
                return false;
            }
        }
        return true;
    }

    public boolean oneEditAway2(String a, String b) {
        int n = a.length(), m = b.length();
        if (Math.abs(n - m) > 1) {
            return false;
        }
        if (n > m) {
            return oneEditAway(b, a);
        }
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            char c1 = a.charAt(i), c2 = b.charAt(j);
            if (c1 == c2) {
                i++; j++;
            } else {
                if (n == m) {
                    i++;
                }
                j++;
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
