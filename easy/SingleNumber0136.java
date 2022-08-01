package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/2 11:50
 */
public class SingleNumber0136 {
    public static void main(String[] args) {
        System.out.println(3^1);
    }

    /**
     * 列表操作
     * 时间复杂度：O(n^2)。我们遍历 nums 花费 O(n)的时间。
     * 我们还要在列表中遍历判断是否存在这个数字，花费 O(n)的时间，所以总循环时间为 O(n^2)。
     * 空间复杂度：O(n)。我们需要一个大小为 n的列表保存所有的 nums 中元素。
     */
    public int singleNumber1(int[] nums){
        List<Integer> no_duplicate = new ArrayList<>();
        for (int i:nums){
            if(!no_duplicate.contains(i)){
                no_duplicate.add(i);
            }
            else{
                no_duplicate.remove((Object)i);
            }
        }
        return no_duplicate.get(0);
    }

    /**
     * 哈希
     * 时间复杂度： O(n⋅1)=O(n) 。for 循环的时间复杂度是 O(n) 的。
     * 空间复杂度： O(n) 。hash_table 需要的空间与 nums 中元素个数相等。
     */
    public int singleNumber2(int[] nums){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i:nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        for (int i:nums){
            if (hashMap.get((Object)i)==1){
                return i;
            }
        }
        return 0;
    }
    public int singleNumber3(int[] nums) {
        Map<Integer, Object> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, null);
            } else {
                map.remove(num);
            }
        }
        return map.keySet().iterator().next();
    }

    /**
     * 数学
     * 时间复杂度：O(n + n) = O(n) 。sum 会调用 next 将 nums 中的元素遍历一遍。
     * 我们可以把上述代码看成 sum(list(i, for i in nums)) ，这意味着时间复杂度为 O(n) ，
     * 因为 nums 中的元素个数是 n 个。
     * 空间复杂度： O(n + n) = O(n) 。 set 需要的空间跟 nums 中元素个数相等。
     */
    public int singleNumber4(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumSet = 0;
        int sumObject = 0;
        for (int i:nums){
            if(!set.contains(i)){
                set.add(i);
                sumSet+=i;
            }
            sumObject+=i;
        }
        return sumSet*2-sumObject;
    }

    /**
     * 位操作
     */
    public int singleNumber5(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
