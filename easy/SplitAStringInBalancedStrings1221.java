package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/7 09:18
 */
public class SplitAStringInBalancedStrings1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++){
            if ((s.charAt(i) == 'R')) {
                count++;
            } else {
                count--;
            }
            if (count == 0){
                res++;
            }
        }

        return res;
    }
}
