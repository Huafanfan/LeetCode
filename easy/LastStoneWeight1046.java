package easy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/30 14:08
 */
public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones){
            queue.add(stone);
        }
        while (!queue.isEmpty()){
            int max = queue.poll();
            int littleMax = 0;
            if (!queue.isEmpty()){
                littleMax = queue.poll();
                if (littleMax != max){
                    queue.add(max - littleMax);
                }
            }
            else {
                return max;
            }
        }
        return 0;
    }
}
