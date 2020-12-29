package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/22 13:23
 */
public class SumOfTwoIntegers0371 {
    public int getSum(int a, int b) {
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        int lower,carrier;
        while (true){
            lower=a^b;
            carrier=a&b;
            if(carrier==0){
                break;
            }
            a=lower;
            b=carrier<<1;
        }
        return lower;
        //return getSum(a^b,a&b<<1);
    }
}
