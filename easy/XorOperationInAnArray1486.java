package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/7 09:24
 */
public class XorOperationInAnArray1486 {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i=1; i<n; i++){
            res ^= start + 2 * i;
        }
        return res;
    }
}
