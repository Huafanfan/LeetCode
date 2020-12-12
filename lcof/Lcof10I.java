package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 10:51
 */
public class Lcof10I {
    public int fib(int n) {
        if (n<2){
            return n;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

    /**
     * 100.00%
     * 68.51%
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n<2){
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        int result = 0;
        for (int i=2; i<=n; i++){
            result = (n1 + n2)%1000000007;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
