package lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 17:38
 */
public class Lcof31 {
    /**
     * 95.52%
     * 84.90%
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i=0;
        for (int num : pushed){
            stack.offerLast(num);
            // 循环判断与出栈
            while(!stack.isEmpty() && stack.peekLast() == popped[i]) {
                stack.pollLast();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{4,0,1,2,3};
        int[] popped = new int[]{4,2,3,0,1};
        Lcof31 lcof31 = new Lcof31();
        System.out.println(lcof31.validateStackSequences(pushed, popped));
    }
}
