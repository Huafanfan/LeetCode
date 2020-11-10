package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/10 09:45
 */
public class KClosestPointstoOrigin0973 {
    long Max = 0L;
    int maxIndex;
    public int[][] kClosest(int[][] points, int K) {
        List<List<Integer>> result = new ArrayList<>();
        int resultCount = 0;
        for (int i=0; i<points.length; i++){
            if (resultCount < K - 1){
                List<Integer> tempList = new ArrayList<>();
                tempList.add(points[i][0]);
                tempList.add(points[i][1]);
                result.add(tempList);
                resultCount++;
            }
            else if (resultCount == K - 1){
                List<Integer> tempList = new ArrayList<>();
                tempList.add(points[i][0]);
                tempList.add(points[i][1]);
                result.add(tempList);
                resultCount++;
                updateMax(result);
            }
            else {
                if (distance(points[i][0], points[i][1]) < Max){
                    result.remove(maxIndex);
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(points[i][0]);
                    tempList.add(points[i][1]);
                    result.add(tempList);
                    updateMax(result);
                }
            }
        }
        int[][] res = new int[K][2];
        for (int i=0; i<K; i++){
            res[i][0] = result.get(i).get(0);
            res[i][1] = result.get(i).get(1);
        }
        return res;
    }

    public long distance (int x, int y){
        return x * x + y * y;
    }

    public void updateMax(List<List<Integer>> result){
        long tempDistance = 0L;
        long tempMax = 0L;
        for (int i = 0; i<result.size(); i++){
            tempDistance = distance(result.get(i).get(0), result.get(i).get(1));
            if ( tempDistance > tempMax){
                tempMax = tempDistance;
                maxIndex = i;
            }
        }
        Max = tempMax;
    }

    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosestQueue(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }

    Random rand = new Random();

    public int[][] kClosestQuickSort(int[][] points, int K) {
        int n = points.length;
        randomSelect(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void randomSelect(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            randomSelect(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            randomSelect(points, i + 1, right, K - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

    public static void main(String[] args) {
        KClosestPointstoOrigin0973 kClosestPointstoOrigin0973 = new KClosestPointstoOrigin0973();
        int[][] points = new int[][]{{1, 3},{-2, 2}};
        int K = 1;
        System.out.println(Arrays.deepToString(kClosestPointstoOrigin0973.kClosest(points, K)));
    }
}
