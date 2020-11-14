package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/14 09:53
 */
public class RelativeSortArray1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr2.length; i++){
            map.put(arr2[i], i);
        }
        int[] arrCount = new int[arr2.length];
        List<Integer> extraNums = new ArrayList<>();

        for (int num : arr1){
            if (map.containsKey(num)){
                int index = map.get(num);
                arrCount[index]++;
            }
            else {
                extraNums.add(num);
            }
        }
        int[] result = new int[arr1.length];
        int resultCount = 0;
        for (int num : arr2){
            int count = arrCount[map.get(num)];
            for (int i=0; i<count; i++){
                result[resultCount++] = num;
            }
        }
        Collections.sort(extraNums);
        for (int num : extraNums){
            result[resultCount++] = num;
        }
        return result;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RelativeSortArray1122 relativeSortArray1122 = new RelativeSortArray1122();
        //int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        //int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] arr1 = new int[]{943,790,427,722,860,550,225,846,715,320};
        int[] arr2 = new int[]{943,715,427,790,860,722,225,320,846,550};
        System.out.println(Arrays.toString(relativeSortArray1122.relativeSortArray(arr1, arr2)));
    }
}
