package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 11:22
 */
public class Lcof56I {
    /**
     * 100.00%
     * 81.50%
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums){
            res ^= num;
        }
        int div = 1;
        while ((res & div) == 0){
            div <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums){
            if ((num & div) != 0){
                a ^= num;
            }
            else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
