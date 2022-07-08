package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/8 10:52
 */
public class MinimumCostToMoveChipsToTheSamePosition1217 {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int p : position){
            if (p % 2 == 0){
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
