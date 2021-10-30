package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/30 09:19
 */
public class SingleNumberIii0260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int index = 0;
        while (true){
            if ((xor & (1 << index++)) != 0){
                break;
            }
        }
        int firstNum = 0;
        int secondNum = 0;
        int mark = 1 << --index;
        //int mark = (xor == Integer.MIN_VALUE ? xor : xor & (-xor));
        for (int num : nums){
            if ((num & mark) == 0){
                firstNum ^= num;
            }
            else {
                secondNum ^= num;
            }
        }
        return new int[]{firstNum, secondNum};
    }

    public static void main(String[] args) {
        SingleNumberIii0260 singleNumberIii0260 = new SingleNumberIii0260();
        int[] nums = new int[]{1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumberIii0260.singleNumber(nums)));
    }
}
