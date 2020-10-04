package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/4 09:49
 */
public class UlBDOe0019 {
    public int minimumOperationsDP(String leaves) {
        int n = leaves.length();
        //0红、1黄、2红
        //f[i][j] 表示对于第 0 片到第 i 片叶子（记为 leaves[0..i]）进行调整操作，并且第 i 片叶子处于状态 j 时的最小操作次数
        int[][] f = new int[n][3];
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        //第0片叶子是黄，第0片叶子是2红，第1片叶子是2红，这三种情况都是不存在的，因为每种叶子都需要只要一个。
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            //当 j=0 时，我们需要将第 i 片叶子变成红色，并且第 i-1 片叶子也只能处于 j=0 的状态
            f[i][0] = f[i - 1][0] + isYellow;
            //当 j=1 时，我们需要将第 i 片叶子变成黄色，而第 i-1 片叶子既可以处于 j=1 的状态，也可以处于 j=0 的状态，我们选择其中的较小值
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                //当 j=2 时，我们需要将第 i 片叶子变成红色，而第 i-1 片叶子即可以处于 j=2 的状态，也可以处于 j=1 的状态，我们选择其中的较小值
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        return f[n - 1][2];
    }
}
