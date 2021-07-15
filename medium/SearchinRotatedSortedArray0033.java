package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/30 14:49
 */
public class SearchinRotatedSortedArray0033 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length==0){
            return -1;
        }
        if(length==1){
            return nums[0]==target?0:-1;
        }
        int left=0;
        int right=length-1;
        while (left<=right){
            int middle = (left+right)>>2;
            if (nums[middle]==target){
                return middle;
            }
            if(nums[0]<=nums[middle]){
                if (nums[0]<=target&&target<nums[middle]){
                    right = middle-1;
                }
                else{
                    left=middle+1;
                }
            }
            else {
                if (nums[middle]<target&&target<=nums[length-1]){
                    left=middle+1;
                }
                else {
                    right=middle-1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i;
                break;
            }
        }
        int ans = find(nums, 0, idx, target);
        if (ans != -1) return ans;
        if (idx + 1 < n) ans = find(nums, idx + 1, n - 1, target);
        return ans;
    }
    int find(int[] nums, int l, int r, int target) {
        while (l < r) {
            //这里有两种写反，由于向下取整，所以有差异
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }

//            int mid = l + r>> 1;
//            if (nums[mid] >= target) {
//                r = mid;
//            } else {
//                l = mid + 1;
//            }
        }
        return nums[l] == target ? l : -1;
    }
}
