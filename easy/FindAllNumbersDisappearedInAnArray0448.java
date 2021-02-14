package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 14:46
 */
public class FindAllNumbersDisappearedInAnArray0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len; i++){
            while (nums[i] != -1 && nums[i] != i+1){
                if(nums[nums[i]-1] != nums[i]){
                    swap(nums, i, nums[i]-1);
                }
                else {
                    nums[i] = -1;
                    break;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<len; i++){
            if (nums[i] == -1){
                res.add(i + 1);
            }
        }
        return res;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        FindAllNumbersDisappearedInAnArray0448 findAllNumbersDisappearedInAnArray0448 = new FindAllNumbersDisappearedInAnArray0448();
        System.out.println(findAllNumbersDisappearedInAnArray0448.findDisappearedNumbers(nums));
    }
}
