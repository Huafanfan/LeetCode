package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 13:12
 */
public class Lcof10II {
    /**
     * 100.00%
     * 23.04%
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n<2){
            return 1;
        }
        int n0 = 1;
        int n1 = 1;
        int result = 0;
        for (int i=2; i<=n; i++){
            result = n1 + n0;
            n0 = n1;
            n1 = result;
        }
        return result;
    }
}
