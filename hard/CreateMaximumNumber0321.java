package hard;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/15 11:00
 */
public class CreateMaximumNumber0321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        String max = "";
        for (int i=0; i<=k; i++) {
            int j = k-i;
            List<Integer> num1 = maxNum(nums1, i);
            List<Integer> num2 = maxNum(nums2, j);
            String tempList = merge(num1, num2);
            if (tempList.length() > max.length()) {
                max = tempList;
            } else if (tempList.length() == max.length()){
                if (max.compareTo(tempList) < 0){
                    max = tempList;
                }
            }
        }
        int[] result = new int[max.length()];
        for (int i=0; i<result.length; i++){
            result[i] = max.charAt(i) - '0';
        }
        return result;
    }

    public List<Integer> maxNum(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int length = nums.length;
        int rmNum = length - k;
        if (rmNum < 0) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums){
                result.add(num);
            }
            return result;
        }
        for (int i=0; i<length; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && rmNum>0 && deque.peekLast() < num) {
                deque.pollLast();
                rmNum--;
            }
            deque.offerLast(num);
        }
        while (rmNum > 0){
            deque.pollLast();
            rmNum--;
        }
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()){
            result.add(deque.pollFirst());
        }
        return result;
    }

    public String merge(List<Integer> num1 , List<Integer> num2) {
        StringBuilder result = new StringBuilder();
        int i=0, j=0;
        while (i!=num1.size() || j!=num2.size()) {
            int digit1 = i==num1.size() ? 0 : num1.get(i);
            int digit2 = j==num2.size() ? 0 : num2.get(j);
            if (compare(num1, i, num2, j) > 0) {
                result.append(digit1);
                i++;
            }
            else {
                result.append(digit2);
                j++;
            }
            if (i == num1.size()){
                while (j!=num2.size()){
                    result.append(num2.get(j++));
                }
            }
            else if (j == num2.size()){
                while (i!=num1.size()){
                    result.append(num1.get(i++));
                }
            }
        }
        return result.toString();
    }

    public int compare(List<Integer> num1, int index1, List<Integer> num2, int index2) {
        int x = num1.size(), y = num2.size();
        while (index1 < x && index2 < y) {
            int difference = num1.get(index1) - num2.get(index2);
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    public static void main(String[] args) {
        CreateMaximumNumber0321 createMaximumNumber0321 = new CreateMaximumNumber0321();
        //int[] nums1 = new int[]{3, 4, 6, 5};
        //int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int[] nums1 = new int[]{6, 7};
        int[] nums2 = new int[]{6, 0, 4};
        //int[] nums1 = new int[]{3,9};
        //int[] nums2 = new int[]{8,9};
        //int[] nums1 = new int[]{2,5,6,4,4,0};
        //int[] nums2 = new int[]{7,3,8,0,6,5,7,6,2};
        //int[] nums1 = new int[]{8,5,9,5,1,6,9};
        //int[] nums2 = new int[]{2,6,4,3,8,4,1,0,7,2,9,2,8};
        //createMaximumNumber0321.maxNum(nums2, 5);
        System.out.println(Arrays.toString(createMaximumNumber0321.maxNumber(nums1, nums2, 5)));
    }
}
