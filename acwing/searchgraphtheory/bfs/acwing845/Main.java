package acwing.searchgraphtheory.bfs.acwing845;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/9/17 3:46 PM
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        StringBuilder start = new StringBuilder();
        for (int i=0; i<9; i++){
            start.append(in.next());
        }
        System.out.println(bfs(start.toString()));
    }

    static int bfs(String start){
        String end = "12345678x";
        Deque<String> q = new ArrayDeque<>();
        Map<String, Integer> d = new HashMap<>();
        q.addLast(start);
        d.put(start, 0);

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!q.isEmpty()){
            String t = q.pollFirst();
            if (t.equals(end)){
                return d.get(t);
            }

            // 状态转移
            int k = t.indexOf("x");
            int x = k / 3, y = k % 3;

            for (int i=0; i<4; i++){
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3){
                    char[] chars = t.toCharArray();
                    char tmp = chars[k];
                    chars[k] = chars[a * 3 + b];
                    chars[a * 3 + b] = tmp;

                    String nt = String.valueOf(chars);
                    if (!d.containsKey(nt)){
                        d.put(nt, d.get(t) + 1);
                        q.addLast(nt);
                    }

                }
            }
        }
        return -1;
    }
}
