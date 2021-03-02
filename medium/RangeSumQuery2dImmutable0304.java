package medium;

import java.util.*;

public class RangeSumQuery2dImmutable0304 {
    int[][] tempMatrix;
    Map<List<Integer>, Integer> map;
    public RangeSumQuery2dImmutable0304(int[][] matrix) {
        int m = matrix.length;
        if (m > 0){
            int n = matrix[0].length;
            if (n > 0){
                tempMatrix = new int[m][n];
                map = new HashMap<>(m * n);
                for (int i=0; i<m; i++){
                    System.arraycopy(matrix[i], 0, tempMatrix[i], 0, n);
                }
                int firstLineSum = 0;
                for (int j=0; j<n; j++){
                    firstLineSum += tempMatrix[0][j];
                    List<Integer> index = new ArrayList<>();
                    index.add(0);
                    index.add(j);
                    map.put(index, firstLineSum);
                }
                for (int i=1; i<m; i++){
                    tempMatrix[i][0] += tempMatrix[i-1][0];
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(0);
                    map.put(index, tempMatrix[i][0]);

                    for (int j=1; j<n; j++){
                        tempMatrix[i][j] += tempMatrix[i-1][j];
                        int k = j;
                        int sum = 0;
                        while (k>=0){
                            sum += tempMatrix[i][k];
                            k--;
                        }
                        List<Integer> index2 = new ArrayList<>();
                        index2.add(i);
                        index2.add(j);
                        map.put(index2, sum);
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        List<Integer> leftTop = new ArrayList<>();
        List<Integer> LetfDown = new ArrayList<>();
        List<Integer> rightTop = new ArrayList<>();
        List<Integer> rightDown = new ArrayList<>();
        leftTop.add(row1-1);
        leftTop.add(col1-1);
        rightTop.add(row1-1);
        rightTop.add(col2);
        LetfDown.add(row2);
        LetfDown.add(col1-1);
        rightDown.add(row2);
        rightDown.add(col2);
        return map.get(rightDown) - map.getOrDefault(LetfDown, 0) - map.getOrDefault(rightTop, 0) + map.getOrDefault(leftTop, 0);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {
                3, 0, 1, 4, 2
            },
            {
                5, 6, 3, 2, 1
            },
            {
                1, 2, 0, 1, 5
            },
            {
                4, 1, 0, 1, 7
            },
            {
                1, 0, 3, 0, 5
            }
        };
        RangeSumQuery2dImmutable0304 rangeSumQuery2dImmutable0304 = new RangeSumQuery2dImmutable0304(matrix);
        System.out.println(rangeSumQuery2dImmutable0304.sumRegion(1,1,2,2));
    }
}
