package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/25 10:29
 */
public class UniqueSubstringsInWraparoundString0467 {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        int n = chars.length;
        int k = 0;
        for (int i=0; i<n; i++){
            if (i > 0 && (chars[i] - chars[i-1] + 26) % 26 == 1){
                k++;
            } else {
                k = 1;
            }
            dp[chars[i] - 'a'] = Math.max(dp[chars[i] - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}
