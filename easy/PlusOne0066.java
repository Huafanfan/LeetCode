package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/21 09:20
 */
public class PlusOne0066 {
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--){
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
