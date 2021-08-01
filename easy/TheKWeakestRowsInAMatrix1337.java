package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/8/1 19:10
 */
public class TheKWeakestRowsInAMatrix1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<mat.length; i++){
            int l = 0, r = mat[0].length - 1, pos = -1;
            while (l <= r){
                int mid = (r - l) / 2 + l;
                if (mat[i][mid] == 0){
                    r = mid - 1;
                }
                else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            list.add(new int[]{pos + 1, i});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1 != o2){
                    return o1[0] - o2[0];
                }
                else {
                    return o1[1] - o2[1];
                }
            }
        });
        int[] res = new int[k];
        for (int i=0; i<k; i++){
            res[i] = list.get(i)[1];
        }
        return res;
    }
}
