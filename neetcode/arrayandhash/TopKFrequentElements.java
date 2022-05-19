package neetcode.arrayandhash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/19 11:46
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();
        for (int i=0; i<=nums.length; i++){
            freq.add(new ArrayList<>());
        }
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i=freq.size()-1; i>=0; i--){
            for (int j=0; j<freq.get(i).size(); j++){
                res[index++] = freq.get(i).get(j);
                if (index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
