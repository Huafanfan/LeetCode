package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/4 18:10
 */
public class FibonacciNumber0509 {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int dp0 = 0;
        int dp1 = 1;
        for(int i=2; i<=n; i++){
            int tmp = dp0 + dp1;
            dp0 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }
}
