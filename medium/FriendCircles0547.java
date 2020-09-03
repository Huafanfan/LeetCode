package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/3 15:53
 */
public class FriendCircles0547 {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int result = 0;
        int[] mark = new int[n];
        for (int i=0; i<n; i++){
            if (mark[i] == 0){
                dfs(M,mark,i);
                result++;
            }
        }
        return result;
    }
    public void dfs(int[][] M, int[] mark, int i){
        for (int j=0; j<M.length; j++){
            if (M[i][j]==1 && mark[j]==0){
                mark[j] = 1;
                dfs(M,mark,j);
            }
        }
    }

    public int findCircleNumBFS(int[][] M) {
        int result = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visit = new int[M.length];
        for (int i=0; i<M.length; i++){
            if (visit[i]==0){
                queue.add(i);
                while (!queue.isEmpty()){
                    int tmp = queue.poll();
                    visit[tmp] = 1;
                    for (int j=0; j<M.length; j++){
                        if (M[tmp][j]==1 && visit[j]==0){
                            queue.add(j);
                        }
                    }
                }
                result++;
            }
        }
        return result;
    }
}
