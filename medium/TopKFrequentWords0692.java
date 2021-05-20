package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/20 14:07
 */
public class TopKFrequentWords0692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map  = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (int i=0; i<k; i++){
            int maxCount = Integer.MIN_VALUE;
            String key = null;
            for (Map.Entry<String, Integer> entry : map.entrySet()){
                if (entry.getValue() >= maxCount){
                    if (entry.getValue() > maxCount){
                        maxCount = entry.getValue();
                        key = entry.getKey();
                    }
                    else {
                        if (key != null){
                            if (entry.getKey().compareTo(key) < 0){
                                key = entry.getKey();
                            }
                        }
                    }
                }
            }
            res.add(key);
            map.remove(key);
        }
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("m".compareTo("l"));
    }
}
