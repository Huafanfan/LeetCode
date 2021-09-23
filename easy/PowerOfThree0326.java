package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/23 10:29
 */
public class PowerOfThree0326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        while (true){
            if (n % 3 != 0){
                return false;
            }
            else {
                n /= 3;
                if (n == 1){
                    return true;
                }
            }
        }
    }
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

}
