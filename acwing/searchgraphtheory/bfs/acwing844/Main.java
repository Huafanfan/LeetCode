package acwing.searchgraphtheory.bfs.acwing844;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/9/17 3:46 PM
 */
public class Main {
    static Map<Integer, Integer> PII = new HashMap<>();
    static int n, m;
    static int N = 110;
    static int[][] g = new int[N][N];
    static int[][] d = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                g[i][j] = in.nextInt();
            }
        }
        System.out.println(bfs());
    }
    static int bfs(){
        Deque<List<Integer>> deque = new ArrayDeque<>();
        deque.add(new ArrayList<>(){{
            add(0);
            add(0);
        }});
        d[0][0] = 1;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while (!deque.isEmpty()){
            List<Integer> t = deque.pollFirst();
            for (int i=0; i<4; i++){
                int x = t.get(0) + dx[i], y = t.get(1) + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == 0){
                    d[x][y] = d[t.get(0)][t.get(1)] + 1;
                    deque.addLast(new ArrayList<>(){{
                        add(x);
                        add(y);
                    }});
                }
            }
        }
        return d[n-1][m-1] - 1;
    }
}
