package medium;

public class HIndexII0275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len;
        while (left < right){
            int mid = (left + right + 1) / 2;
            int count = 0;
            for (int citation : citations){
                if (citation >= mid){
                    count++;
                }
            }
            if (count >= mid){
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
