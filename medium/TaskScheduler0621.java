package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/5 09:26
 */
public class TaskScheduler0621 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0) + 1;
            map.put(task, count);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int N = n;
        int minTime = 0;
        while (!list.isEmpty()) {
            int first = 0;
            Map.Entry<Character, Integer> entry = list.get(first);
            if (N>=0){
                entry.setValue(entry.getValue()-1);
                if (entry.getValue()==0) {
                    list.remove(first--);
                }
                N--;
                first++;
                minTime++;
            }
            while (N>=0){
                if (list.size()>first){
                    entry = list.get(first);
                    entry.setValue(entry.getValue()-1);
                    if (entry.getValue()==0){
                        list.remove(first--);
                    }
                    N--;
                    first++;
                    minTime++;
                }
                else {
                    if (list.size()==0) {
                        return minTime;
                    }
                    N--;
                    minTime++;
                }
            }
            N = n;
            list.sort(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
        }
        return minTime;
    }

    public int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        //char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        //char[] tasks = new char[]{'A','A','A','B','B','B'};
        char[] tasks = new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'};
        TaskScheduler0621 taskScheduler0621 = new TaskScheduler0621();
        System.out.println(taskScheduler0621.leastInterval(tasks, 2));
    }
}
