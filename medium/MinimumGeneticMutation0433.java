package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/7 10:13
 */
public class MinimumGeneticMutation0433 {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)){
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        Collections.addAll(bankSet, bank);
        if (!bankSet.contains(end)){
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                String cur = queue.poll();
                for (int j=0; j<8; j++){
                    for (int k=0; k<4; k++){
                        if (keys[k] != cur.charAt(j)){
                            StringBuilder sb = new StringBuilder(cur);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (bankSet.contains(next) && !visited.contains(next)){
                                if (next.equals(end)){
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] keys = {'A', 'C', 'G', 'T'};
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        d1.offer(start);
        m1.put(start, 0);
        d2.offer(end);
        m2.put(end, 0);
        Deque<String> d;
        Map<String, Integer> mapCur;
        Map<String, Integer> mapOther;
        while (!d1.isEmpty() && !d2.isEmpty()) {
            if (d1.size() <= d2.size()) {
                d = d1;
                mapCur = m1;
                mapOther = m2;
            } else {
                d = d2;
                mapCur = m2;
                mapOther = m1;
            }
            int size = d.size();
            while (size-- > 0) {
                String cur = d.poll();
                int step = mapCur.get(cur);
                for (int i = 0; i < 8; i++) {
                    for (char c : keys) {
                        if (cur.charAt(i) != c) {
                            StringBuilder sb = new StringBuilder(cur);
                            sb.setCharAt(i, c);
                            String next = sb.toString();
                            if (!bankSet.contains(next)) {
                                continue;
                            }
                            if (mapOther.containsKey(next)) {
                                return step + 1 + mapOther.get(next);
                            }
                            if (!mapCur.containsKey(next)) {
                                mapCur.put(next, step + 1);
                                d.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}

//    int update(Deque<String> d, Map<String, Integer> mapCur, Map<String, Integer> mapOther, Set<String> bankSet) {
//
//        int size = d.size();
//        while (size-- > 0) {
//            String cur = d.poll();
//            int step = mapCur.get(cur);
//            for (int i = 0; i < 8; i++) {
//                for (char c : keys) {
//                    if (cur.charAt(i) != c) {
//                        StringBuilder sb = new StringBuilder(cur);
//                        sb.setCharAt(i, c);
//                        String next = sb.toString();
//                        if (!bankSet.contains(cur)){
//                            continue;
//                        }
//                        if (mapOther.containsKey(next)){
//                            return step + 1 + mapOther.get(next);
//                        }
//                        if (!mapCur.containsKey(cur)){
//                            mapCur.put(cur, step + 1);
//                            d.offer(next);
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//}
