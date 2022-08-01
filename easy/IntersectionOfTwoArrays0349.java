package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/21 14:35
 */
public class IntersectionOfTwoArrays0349 {
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> setNum1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int temp:nums1){
            setNum1.add(temp);
        }
        for(int temp:nums2){
            if (setNum1.contains(temp)){
                result.add(temp);
            }
        }
        int[] a = new int[result.size()];
        int i=0;
        for(Integer temp:result){
            a[i++] = temp;
        }
        return a;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) {
            output[idx++] = s;
        }
        return output;
    }

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }

        return res;
    }

    /**
     * 二分查找
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection4(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int target : nums1) {
            if (binarySearch(nums2, target)) {
                set.add(target);
            }
        }
        int index = 0;
        int[] res = new int[set.size()];
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }
    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
