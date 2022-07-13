package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/13 09:53
 */
public class AsteroidCollision0735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids){
            boolean aLive = true;
            // 只有栈顶向右，当前向左这一种情况会爆炸
            while (aLive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0){
                aLive = -asteroid > stack.peek();
                if (-asteroid >= stack.peek()){
                    stack.pop();
                }
            }
            if (aLive){
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
