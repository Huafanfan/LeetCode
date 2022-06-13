package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/13 10:38
 */
public class FlipStringToMonotoneIncreasing0926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp1 = 0, dp0 = 0;
        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            int dpNew0 = dp0;
            int dpNew1 = Math.min(dp0, dp1);
            if (c == '1'){
                dpNew0++;
            } else {
                dpNew1++;
            }
            dp0 = dpNew0;
            dp1 = dpNew1;
        }
        return Math.min(dp0, dp1);
    }
}
