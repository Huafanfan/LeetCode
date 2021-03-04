package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DailyTemperatures0736 {
    //temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        res[len-1] = -1;
        for (int i=len - 2; i>=0; i--){
            int next = i+1;
            while (T[i] >= T[next]){
                if (res[next] == -1){
                    res[i] = -1;
                    break;
                }
                else {
                    next = next + res[next];
                }
            }
            if (res[i] != -1){
                res[i] = next - i;
            }
        }
        for (int i=0; i<len; i++){
            if (res[i] == -1){
                res[i] = 0;
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures0736 dailyTemperatures0736 = new DailyTemperatures0736();
        System.out.println(Arrays.toString(dailyTemperatures0736.dailyTemperatures(T)));
    }
}
