package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 10:07
 */
public class Lcof64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
