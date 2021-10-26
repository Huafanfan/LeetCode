package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/8 11:27
 */
public class NextGreaterElementIi0503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i=0; i<len; i++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.poll()] = nums[i];
            }
            stack.push(i);
        }
        for (int num : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.poll()] = num;
            }
        }

        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        for (int i = 2 * nums.length-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        NextGreaterElementIi0503 nextGreaterElementIi0503 = new NextGreaterElementIi0503();
        System.out.println(Arrays.toString(nextGreaterElementIi0503.nextGreaterElements2(nums)));
    }
}
