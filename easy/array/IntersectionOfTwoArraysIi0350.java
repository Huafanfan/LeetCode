package easy.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/24 23:52
 */
public class IntersectionOfTwoArraysIi0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1){
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2){
            if(map1.containsKey(num)){
                res.add(num);
                int count = map1.get(num) - 1;
                if (count == 0){
                    map1.remove(num);
                }
                else {
                    map1.put(num, count);
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for (int i=0, j=0; i<nums1.length && j<nums2.length;){
            if (nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else {
                if (nums1[i] < nums2[j]){
                    i++;
                }
                else {
                    j++;
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
