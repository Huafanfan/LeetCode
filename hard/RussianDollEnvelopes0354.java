package hard;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes0354 {
    public int maxEnvelopes(int[][] envelopes) {
        int size = envelopes.length;
        if (size < 1){
            return 0;
        }
        //我们可以将 h 值作为排序的第二关键字进行降序排序，
        // 这样一来，对于每一种 w 值，其对应的信封在排序后的数组中是按照 h 值递减的顺序出现的，
        // 那么这些 h 值不可能组成长度超过 1 的严格递增的序列
        //
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        int max = 1;
        int[] dp = new int[size];
        dp[0] = 1;

        for (int i=1; i<size; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        int size = envelopes.length;
        if (size < 1){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        int len = 1;
        int[] d = new int[size + 1];
        d[len] = envelopes[0][1];

        for (int i=1; i<size; i++){
            if (envelopes[i][1] > d[len]){
                d[++len] = envelopes[i][1];
            }
            else {
                int l = 1, r = len, pos = 0;
                while (l <= r){
                    int mid = (l + r) >> 1;
                    if (d[mid] < envelopes[i][1]){
                        pos = mid;
                        l = mid + 1;
                    }
                    else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = envelopes[i][1];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        //int[][] envelopes = new int[][]{{1, 100}, {1, 200}, {1, 300}, {1, 500}, {1, 400}};
        RussianDollEnvelopes0354 russianDollEnvelopes0354 = new RussianDollEnvelopes0354();
        System.out.println(russianDollEnvelopes0354.maxEnvelopes2(envelopes));
    }
}
