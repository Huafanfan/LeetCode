package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/7 11:00
 */
public class NumberofProvinces0547 {
    public int findCircleNum1(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i=0; i<provinces; i++){
            if (!visited[i]){
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int index){
        for (int j=0; j<provinces; j++){
            if (isConnected[index][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }

    public int findCircleNum2(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            visited[k] = true;
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }
}
