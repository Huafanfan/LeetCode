package easy.array;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/29 21:33
 */
public class PlusOne0066 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i=length-1; i>=0; i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }
}
