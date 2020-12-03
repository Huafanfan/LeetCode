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
        System.out.println(decodeWays0091.numDecodings("226"));
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
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=s.length(); i++){
            int num = Integer.parseInt(s.substring(i-1, i));
            if (num>=1 && num<=9){
                dp[i] += dp[i-1];
            }
            num = Integer.parseInt(s.substring(i-2, i));
            if (num>=10 && num<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
