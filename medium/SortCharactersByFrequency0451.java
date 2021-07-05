package medium;

import java.util.*;

public class SortCharactersByFrequency0451 {
    public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> list = new ArrayList<>(countMap.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return countMap.get(o2) - countMap.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character ch : list){
            int count = countMap.get(ch);
            while (count-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
