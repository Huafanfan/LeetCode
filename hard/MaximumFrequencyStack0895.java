package hard;

import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/11/30 22:18
 */
public class MaximumFrequencyStack0895 {
    Map<Integer, Integer> cnts;
    List<Deque<Integer>> stacks;
    public MaximumFrequencyStack0895() {
        cnts = new HashMap<>();
        stacks = new ArrayList<>();
    }

    public void push(int val) {
       int c = cnts.getOrDefault(val, 0);
       if (c == stacks.size()){
           stacks.add(new ArrayDeque<>());
       }
       stacks.get(c).addLast(val);
       cnts.put(val, c + 1);
    }

    public int pop() {
        int back = stacks.size()-1;
        int val = stacks.get(back).pollLast();
        if (stacks.get(back).size() == 0){
            stacks.remove(back);
        }
        cnts.put(val, cnts.get(val) - 1);
        return val;
    }
}
