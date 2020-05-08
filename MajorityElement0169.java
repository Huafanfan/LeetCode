package com.huafanfan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/6 18:03
 */
public class MajorityElement0169 {
    /**
     * 哈希表
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。我们遍历数组 nums 一次，对于 nums 中的每一个元素，
     * 将其插入哈希表都只需要常数时间。如果在遍历时没有维护最大值，在遍历结束后还需要对哈希表进行遍历，
     * 因为哈希表中占用的空间为 O(n)（可参考下文的空间复杂度分析），那么遍历的时间不会超过 O(n)。
     * 因此总时间复杂度为 O(n)。
     * 空间复杂度：O(n)。哈希表最多包含 n−⌊n/2⌋ 个键值对，所以占用的空间为 O(n)。
     * 这是因为任意一个长度为 n 的数组最多只能包含 n 个不同的值，但题中保证 nums 一定有一个众数，
     * 会占用（最少） ⌊n/2⌋+1 个数字。因此最多有 n−(⌊n/2⌋+1) 个不同的其他数字，
     * 所以最多有 n−⌊n/2⌋ 个不同的元素。
     */

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    /**
     * 排序
     * 时间复杂度：O(nlogn)。将数组排序的时间复杂度为 O(nlogn)。
     * 空间复杂度：O(logn)。如果使用语言自带的排序算法，需要使用 O(logn) 的栈空间。如果自己编写堆排序，
     * 则只需要使用 O(1) 的额外空间。
     */
    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 随机
     */
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int value : nums) {
            if (value == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElementRange(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length/2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    /**
     * 分治
     */

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElementDivideAndConquer(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    /**
     * Boyer-Moore 投票算法
     * 时间复杂度：O(n)。Boyer-Moore 算法只对数组进行了一次遍历。
     * 空间复杂度：O(1)。Boyer-Moore 算法只需要常数级别的额外空间
     */
    public int majorityElementVote(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
