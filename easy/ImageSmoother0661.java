package easy;

import java.rmi.server.LogStream;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/3/24 10:37
 */
public class ImageSmoother0661 {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for (int i=0; i<img.length; i++){
            for (int j=0; j<img[i].length; j++){
                int num = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < img.length && y >= 0 && y < img[i].length) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }
                res[i][j] = sum / num;
            }
        }
        return res;
    }

    public int[][] imageSmoother2(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] sum = new int[m + 1][n + 1];
        int[][] res = new int[m][n];
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + img[i-1][j-1];
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int leftX = Math.max(0, i-1);
                int leftY = Math.max(0, j-1);

                int rightX = Math.min(m-1, i+1);
                int rightY = Math.min(n-1, j+1);
                int count = (rightX - leftX + 1) * (rightY - leftY + 1);
                int tol = sum[rightX + 1][rightY + 1] - sum[leftX][rightY + 1] - sum[rightX + 1][leftY] + sum[leftX][leftY];
                res[i][j] = tol / count;
            }
        }
        return res;
    }
}
