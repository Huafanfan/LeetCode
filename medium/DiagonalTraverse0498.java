package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/14 13:52
 */
public class DiagonalTraverse0498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int index = 0;
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        boolean up = true;
        for (int sum = 0; sum <= (n-1) + (m-1); sum++){
            if (up){
                int start = Math.min(m-1, sum);
                for (; (sum - start) < n && start >= 0; start--){
                    ans[index++] = mat[start][sum - start];
                }
            } else {
                int start = Math.max(sum - (n - 1), 0);
                for (; start < m && sum - start >= 0; start++){
                    ans[index++] = mat[start][sum - start];
                }
            }
            up = !up;
        }
        return ans;
    }

    public static void main(String[] args) {
        DiagonalTraverse0498 d = new DiagonalTraverse0498();
        int[][] mats = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(d.findDiagonalOrder(mats)));
    }
}
