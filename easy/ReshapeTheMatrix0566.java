package easy;

public class ReshapeTheMatrix0566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (r * c != row * col){
            return nums;
        }
        int[][] res = new int[r][c];
        for (int x = 0; x < row * col; ++x) {
            res[x / c][x % c] = nums[x / col][x % col];
        }
        return res;
    }
}
