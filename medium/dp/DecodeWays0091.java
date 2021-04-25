package medium.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 16:27
 */
public class DecodeWays0091 {
    public static void main(String[] args) {
        DecodeWays0091 decodeWays0091 = new DecodeWays0091();
        System.out.println(decodeWays0091.numDecodings2("2611055971756562"));
    }
    public int numDecodings(String s) {
        if (s.charAt(0)=='0'){
            return 0;
        }
        //List<Integer> dp = new ArrayList<>();
        //dp.add(0,1);
        //dp.add(1,1);
        int pre = 1;
        int cur = 1;
        for (int i=1; i<s.length(); i++){
            int tmp = cur;
            if (s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    //dp.add(i+1,dp.get(i-1));
                    cur = pre;
                }
                else {
                    return 0;
                }
            }
            else {
                if (s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)<='6')){
                    //dp.add(i+1, dp.get(i)+dp.get(i-1));
                    cur = cur + pre;
                }
                else{
                    //dp.add(i+1, dp.get(i));
                    cur = cur;
                }
            }
            pre = tmp;
        }
        return cur;
    }

    public int numDecodings2(String s) {
        if (s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length();
        //dp[i] 表示前i个，也就是0到i-1
//        int[] dp = new int[len+1];
//        dp[0] = 1;
//        dp[1] = 1;
        int a = 1, b = 1, c = 0;
        char[] chars = s.toCharArray();
        //for (int i=2; i<=len; i++){
        for (int i=1; i<=len; i++){
            c = 0;
            if (chars[i-1] != '0'){
                //dp[i] += dp[i-1];
                c += b;
            }
            if (i > 1 && (chars[i-2] == '1' || (chars[i-2] == '2' && chars[i-1] <= '6'))){
                //dp[i] += dp[i-2]
                c += a;
            }
            a = b;
            b = c;
        }
        //return dp[len];
        return c;
    }
}
