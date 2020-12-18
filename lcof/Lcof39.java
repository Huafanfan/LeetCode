package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 15:04
 */
public class Lcof39 {
    /**
     * 99.97%
     * 80.26%
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int many = 0;
        int vote = 0;
        for (int num : nums){
            if (vote == 0){
                many = num;
                vote++;
            }
            else if (num == many){
                vote++;
            }else {
                vote--;
            }
        }
        return many;
    }
}
