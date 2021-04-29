package hard;

import java.util.*;

public class FrogJump0403 {
    /**
     * 超出内存限制
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        if (stones[1] != 1){
            return false;
        }
        int n = stones.length;
        List<Set<Integer>> steps = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(stones[i], i);
            steps.add(new HashSet<>());
        }
        steps.get(1).add(1);
        for (int i=1 ; i<stones.length - 1; i++){
            Set<Integer> curSteps = steps.get(i);
            if (curSteps.isEmpty()){
                continue;
            }
            for (int step : curSteps){
                //k - 1, k , k + 1
                for (int k = step - 1; k <= step + 1; k++){
                    Integer nextStone = map.get(k + stones[i]);
                    if (nextStone != null && nextStone != i){
                        steps.get(nextStone).add(k);
                    }
                }
            }
        }
        return !steps.get(n - 1).isEmpty();
    }

    public boolean canCross4(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        //记录到达当前石头的步长集合
        List<Set<Integer>> dp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //初始化 记录 单元格序号 -> 石头序号
        for (int i = 0; i < n; i++){
            map.put(stones[i], i);
            dp.add(new HashSet<>());
        }
        dp.get(1).add(1);
        for (int i = 1; i < n; i++){
            Set<Integer> curSet = dp.get(i);
            if (curSet.isEmpty()){
                continue;
            }
            int curIndex = stones[i];
            //遍历步长集合
            for (int step : curSet){
                //k - 1, k , k + 1
                for (int j = step - 1; j <= step + 1; j++){
                    Integer index = map.get(j + curIndex);
                    if (index != null && index != i){
                        dp.get(index).add(j);
                    }
                }
            }

        }
        return !dp.get(n - 1).isEmpty();
    }

    private Boolean[][] rec;

    public boolean canCross2(int[] stones) {
        int n = stones.length;
        rec = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    private boolean dfs(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) {
            return true;
        }
        if (rec[i][lastDis] != null) {
            return rec[i][lastDis];
        }

        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis > 0) {
                int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
                if (j >= 0 && dfs(stones, j, curDis)) {
                    return rec[i][lastDis] = true;
                }
            }
        }
        return rec[i][lastDis] = false;
    }

    public boolean canCross3(int[] stones) {
        int n = stones.length;
        //dp[i][k] 表示青蛙能否达到「现在所处的石子编号」为 i 且「上一次跳跃距离」为 k 的状态。
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        //优化
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FrogJump0403 frogJump0403 = new FrogJump0403();
        int[] stones = new int[]{0,1,3,6,10,15,16,21};
        int[] stones2 = new int[]{0,1,3,5,6,8,12,17};
        int[] stones3 = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(frogJump0403.canCross(stones));
        System.out.println(frogJump0403.canCross(stones2));
        System.out.println(frogJump0403.canCross(stones3));
    }
}
