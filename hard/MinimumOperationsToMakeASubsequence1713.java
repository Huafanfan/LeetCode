package hard;

import java.util.*;

public class MinimumOperationsToMakeASubsequence1713 {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            pos.put(target[i], i);
        }
        List<Integer> arr1 = new ArrayList<>();
        for (int num : arr){
            if (pos.containsKey(num)){
                arr1.add(pos.get(num));
            }
        }
        return n - lengthOfLIS(arr1);
    }

    public int lengthOfLIS(List<Integer> nums) {
        int index = 1, n = nums.size();
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[index] = nums.get(0);
        for (int i=1; i<nums.size(); i++) {
            if (nums.get(i) > d[index]) {
                d[++index] = nums.get(i);
            } else {
                int l = 0, r = index;
                while (l < r) {
                    int mid = (r - l + 1) / 2 + l;
                    if (d[mid] < nums.get(i)) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                d[l+1] = nums.get(i);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] target = new int[]{12,3,4,5,9,20,18,10,2,19};
        int[] arr = new int[]{2,10,4,9,5,19,18,15,20,10};
        MinimumOperationsToMakeASubsequence1713 minimumOperationsToMakeASubsequence1713 = new MinimumOperationsToMakeASubsequence1713();
        System.out.println(minimumOperationsToMakeASubsequence1713.minOperations(target, arr));
    }
}
