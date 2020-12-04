package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/4 09:23
 */
public class SplitArrayIntoConsecutiveSubsequences0659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums){
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<>());
            }
            if (map.containsKey(x-1)) {
                int prevLength = map.get(x-1).poll();
                if (map.get(x-1).isEmpty()){
                    map.remove(x-1);
                }
                map.get(x).offer(prevLength + 1);
            }
            else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet){
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek()<3) {
                return false;
            }
        }
        return true;
    }

    public boolean isPossible2(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, Integer> listLength = new HashMap<>();
        for (int num : nums) {
            int size = numCount.getOrDefault(num, 0);
            numCount.put(num, size + 1);
        }
        for (int num : nums) {
            int count = numCount.getOrDefault(num, 0);
            if (count>0){
                int pervLength = listLength.getOrDefault(num-1, 0);
                if (pervLength > 0) {
                    numCount.put(num, count-1);
                    listLength.put(num-1, pervLength-1);
                    listLength.put(num, listLength.getOrDefault(num, 0)+1);
                }
                else {
                    int x1Count = numCount.getOrDefault(num+1, 0);
                    int x2Count = numCount.getOrDefault(num+2, 0);
                    if (x1Count > 0 && x2Count > 0) {
                        numCount.put(num, count-1);
                        numCount.put(num+1, x1Count-1);
                        numCount.put(num+2, x2Count-1);
                        listLength.put(num+2, listLength.getOrDefault(num+2, 0) + 1);
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
