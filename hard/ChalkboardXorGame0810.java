package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/22 15:46
 */
public class ChalkboardXorGame0810 {
    public boolean xorGame(int[] nums) {
        int length = nums.length;
        if ((length % 2) == 0){
            return true;
        }
        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }
        return xor == 0;
    }
}
