package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 16:33
 */
public class Lcof15 {
    /**
     * 98.11%
     * 37.59%
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n!=0){
            result++;
            n &= n-1;
        }
        return result;
    }
}
