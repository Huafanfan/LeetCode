package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/18 10:05
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXor1442 {
    public int countTriplets(int[] arr) {
        int length = arr.length;
        int[] s = new int[length + 1];
        for (int i=0; i<length; i++){
            s[i+1] = s[i] ^ arr[i];
        }
        int ans = 0;
        //for (int i=0; i<length; i++){
        //    for (int j=i+1; j<length; j++){
        //        for (int k=j; k<length; k++){
        //            if (s[i] == s[k + 1]){
        //                ans++;
        //            }
        //        }
        //    }
        //}
        //for (int i=0; i<length; i++){
        //    for (int k=j; k<length; k++){
        //        if (s[i] == s[k + 1]){
        //            ans += k - (i + 1) + 1;
        //        }
        //    }
        //}
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();
        for (int k=0; k<length; k++){
            if (cnt.containsKey(s[k + 1])){
                ans += cnt.get(s[k + 1]) * k - sum.get(s[k + 1]);
            }
            cnt.put(s[k], cnt.getOrDefault(s[k], 0) + 1);
            sum.put(s[k], sum.getOrDefault(s[k], 0) + k);
        }
        return ans;
    }
}
