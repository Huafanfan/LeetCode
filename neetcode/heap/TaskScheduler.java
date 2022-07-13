package neetcode.heap;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/13 16:29
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        int count = map.size();
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.addAll(map.values());
        int time = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        while (!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if (!pq.isEmpty()){
                int cnt = pq.poll() - 1;
                if (cnt > 0){
                    Pair p = new Pair();
                    p.cnt = cnt;
                    p.idleTime = time + n;
                    queue.add(p);
                }
            }
            if (!queue.isEmpty() && queue.peek().idleTime == time){
                pq.add(queue.poll().cnt);
            }
        }
        return time;
    }

    public static class Pair {
        int cnt;
        int idleTime;
    }
}
