package hard;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/8 09:11
 */
public class Ipo0502 {
    int maxCap = 0;
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k < 1){
            return 0;
        }
        int n = profits.length;
        boolean[] used = new boolean[n];
        for (int i=0; i<n; i++){
            if (capital[i] <= w){
                used[i] = true;
                maxCap = Math.max(maxCap, w + profits[i]);
                dfs(k-1, w + profits[i], profits, capital, used, 1);
                used[i] = false;
            }
        }
        return maxCap;
    }
    public void dfs(int k, int w, int[] profits, int[] capital, boolean[] used, int count){
        int n = profits.length;
        if (k == 0 || count == n){
            //maxCap = Math.max(maxCap, w);
            return;
        }
        for (int i=0; i<n; i++){
            if (!used[i] && capital[i] <= w){
                used[i] = true;
                maxCap = Math.max(maxCap, w + profits[i]);
                dfs(k-1, w + profits[i], profits, capital, used, count+1);
                used[i] = false;
            }
        }
    }

    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);//大根堆
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }

    public static void main(String[] args) {
        Ipo0502 ipo0502 = new Ipo0502();
        int[] profits = new int[]{1,2,3};
        int[] capital = new int[]{0,1,2};
        System.out.println(ipo0502.findMaximizedCapital2(3,0,profits,capital));
    }
}
