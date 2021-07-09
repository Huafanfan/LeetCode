package easy;

public class FindMajorityElementLcci1710 {
    public int majorityElement(int[] nums) {
        int vote = Integer.MIN_VALUE;
        int count = 0;
        for (int i=0; i<nums.length; i++){
            if (count == 0){
                vote = nums[i];
                count = 1;
            }
            else {
                count = (vote == nums[i]) ? count + 1 : count - 1;
            }
        }
        // 这里的目的就是判断到底是存在的主要元素还是不存在主要元素，而留下的数组饿最后一个元素。
        count = 0;
        for (int num : nums) {
            if (num == vote){
                count++;
            }
            else {
                count--;
            }
        }
        return count > 0 ? vote : -1;
    }
}
