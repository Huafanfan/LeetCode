package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        NextGreaterElementIi0503 nextGreaterElementIi0503 = new NextGreaterElementIi0503();
        System.out.println(Arrays.toString(nextGreaterElementIi0503.nextGreaterElements(nums)));
    }
}
