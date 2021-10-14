package lcofII;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/14 09:32
 */
public class Lcof069 {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i=0; i<arr.length-1; i++){
            if (arr[i] > arr[i+1]){
                return i;
            }
        }
        return arr.length-1;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
