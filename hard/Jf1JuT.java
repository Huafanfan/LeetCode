package hard;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/31 10:12
 * @url https://leetcode.cn/problems/Jf1JuT/
 */
public class Jf1JuT {
    static final int VISITING = 1, VISITED = 2;
    Map<Character, List<Character>> edges = new HashMap<Character, List<Character>>();
    Map<Character, Integer> states = new HashMap<Character, Integer>();
    boolean valid = true;
    char[] order;
    int index;

    public String alienOrder(String[] words) {
        int length = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<Character>());
            }
        }
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        order = new char[edges.size()];
        index = edges.size() - 1;
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!states.containsKey(u)) {
                dfs(u);
            }
        }
        if (!valid) {
            return "";
        }
        return new String(order);
    }

    public void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                break;
            }
            index++;
        }
        if (index == length && length1 > length2) {
            valid = false;
        }
    }

    public void dfs(char u) {
        states.put(u, VISITING);
        List<Character> adjacent = edges.get(u);
        for (char v : adjacent) {
            if (!states.containsKey(v)) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (states.get(v) == VISITING) {
                valid = false;
                return;
            }
        }
        states.put(u, VISITED);
        order[index] = u;
        index--;
    }


    Map<Character, Integer> indegrees = new HashMap<Character, Integer>();
    public String alienOrder2(String[] words) {
        int length = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<Character>());
            }
        }
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        if (!valid) {
            return "";
        }
        Queue<Character> queue = new ArrayDeque<Character>();
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!indegrees.containsKey(u)) {
                queue.offer(u);
            }
        }
        StringBuffer order = new StringBuffer();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            order.append(u);
            List<Character> adjacent = edges.get(u);
            for (char v : adjacent) {
                indegrees.put(v, indegrees.get(v) - 1);
                if (indegrees.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }
        return order.length() == edges.size() ? order.toString() : "";
    }
}
