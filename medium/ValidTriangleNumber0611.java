package medium;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/4 14:23
 */
public class ValidTriangleNumber0611 {
    public static void main(String[] args) {
        ValidTriangleNumber0611 validTriangleNumber0611 = new ValidTriangleNumber0611();
        int[] nums = new int[]{0, 0, 2, 2, 3, 4};
        System.out.println(validTriangleNumber0611.triangleNumberBinary(nums));
    }
    public int triangleNumber(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length-2; i++){
            for (int j=i+1; j<nums.length-1; j++){
                for (int k=j+1; k<nums.length; k++){
                    if (isTriangle(nums[i],nums[j],nums[k])){
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public boolean isTriangle(int i,int j, int k){
        return (i + j) > k && (i + k) > j && (j + k) > i;
    }

    public int triangleNumberBinary(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                int s = nums[i] + nums[j];
                int l = j + 1, r = n - 1;
                while (l <= r) {
                    int mid = l + r >>> 1;
                    if (nums[mid] < s) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                res += l - j - 1;
            }
        }
        return res;
    }

    /**
     * 排序后的倒序判断（由后往前扫）。固定一条最长边 a 之后，剩下的两边都是在比 a 小的数里找的。只要剩余的两边满足 b + c > a，则一定满足 a + c > b 和 a + b > c。
     * @param nums
     * @return
     */
    public int triangleNumberTwoPoint(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }

    //Leetcode 15
    public int threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[l], nums[r], nums[i])));
                    res++;
                    ++l;
                    --r;
                } else if(nums[l] + nums[r] > -nums[i]) {
                    --r;
                }else {
                    l++;
                }
            }
        }
        System.out.println(ans);
        new ArrayList<>(ans);
        return res;
    }
}
