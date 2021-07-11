package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/11 09:26
 */
public class HIndex0274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
