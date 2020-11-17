package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/17 09:34
 */
public class MatrixCellsinDistanceOrder1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxDistance = Integer.MIN_VALUE;
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                int dis = Math.abs(r0 - i) + Math.abs(c0 - j);
                if (dis > maxDistance){
                    maxDistance = dis;
                }
                List<Integer> list = map.getOrDefault(dis, new ArrayList<>());
                list.add(i);
                list.add(j);
                map.put(dis, list);
            }
        }
        int index = 0;
        for (int i=0; i<=maxDistance; i++){
            List<Integer> list = map.get(i);
            for (int j=0; j<list.size();){
                result[index][0] = list.get(j++);
                result[index++][1] = list.get(j++);
            }
        }
        return result;
    }

    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
            }
        });
        return ret;
    }

    public int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<List<int[]>>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    public int[][] allCellsDistOrder4(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int[][] ret = new int[R * C][];
        int row = r0, col = c0;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MatrixCellsinDistanceOrder1030 matrixCellsinDistanceOrder1030 = new MatrixCellsinDistanceOrder1030();
        System.out.println(Arrays.deepToString(matrixCellsinDistanceOrder1030.allCellsDistOrder4(3, 3, 1, 1)));
    }
}
