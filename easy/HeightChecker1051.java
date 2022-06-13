package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/13 10:30
 */
public class HeightChecker1051 {
    public int heightChecker(int[] heights) {
        int[] cnt = new int[101];
        for (int h : heights){
            cnt[h]++;
        }
        int index = 0;
        int ans = 0;
        for (int i=1; i<=100; i++){
            for (int j=1; j<=cnt[i]; j++){
                if (heights[index++] != i){
                    ans++;
                }
            }
        }
        return ans;
    }
}
