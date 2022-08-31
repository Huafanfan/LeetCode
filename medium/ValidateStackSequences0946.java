package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yifan.zhangyf
 * @date 2022/8/31 9:58 PM
 */
public class ValidateStackSequences0946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0, j=0; i < pushed.length; i++){
            stack.addLast(pushed[i]);
            while (!stack.isEmpty() && stack.peekLast() == popped[j]){
                stack.pollLast();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
