package easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alex
 * 题目 #
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 */
public class TwoSum0001 {
	public static void main(String[] args){
		int[] a = new int[] {2, 7, 11, 15};
		System.out.println(twoSum(a,9)[0]);
	}

	/*
	 * 时间复杂度：O(n)
	 * 我们只遍历了包含有n个元素的列表一次。在表中进行的每次查找只花费O(1)的时间。
	 * 空间复杂度：O(n)
	 * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储n个元素。
	 */

	public static int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
			int diff = target-nums[i];
			if(map.containsKey(diff)) {
				return new int[] {map.get(diff),i};
			}
			map.put(nums[i], i);
		}
    	throw new IllegalArgumentException("No two sum solution");
    }

    /*
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费O(n)的时间。因此时间复杂度为 O(n^2)
     * 空间复杂度：O(1)
    */

    public static int[] twoSumForce(int[] nums, int target) {
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
    	throw new IllegalArgumentException("No two sum solution");
    }
}
