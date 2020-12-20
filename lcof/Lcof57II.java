package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 13:46
 */
public class Lcof57II {
    /**
     * 5.09%
     * 5.62%
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int upperBound = target / 2;
        List<List<Integer>> res = new ArrayList<>();
        for (int i=1; i<=upperBound; i++){
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int j=i;;j++){
                sum += j;
                list.add(j);
                if (sum>=target){
                    break;
                }
            }
            if (sum == target){
                res.add(list);
            }
        }
        int[][] ans = new int[res.size()][];
        for (int i=0; i<ans.length; i++){
            ans[i] = new int[res.get(i).size()];
            for (int j=0; j<ans[i].length; j++){
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    /**
     * 63.84%
     * 71.04%
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
