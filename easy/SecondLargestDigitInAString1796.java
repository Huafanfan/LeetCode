package easy;

/**
 * @author yifan.zhangyf
 * @date 2022/12/3 18:26
 */
public class SecondLargestDigitInAString1796 {
    public int secondHighest(String s) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i=0; i<s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                if (num > max){
                    max = num;
                } else if (num > max2){
                    max2 = num;
                }
            }
        }
        return max2 == Integer.MIN_VALUE ? -1 : max2;
    }
}
