package easy;

public class PeakIndexInAMountainArray0852 {
    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        for (int i=1; i<length; i++){
            if (arr[i] < arr[i-1]){
                return i-1;
            }
        }
        return 0;
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
