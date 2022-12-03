package easy;

/**
 * @author yifan.zhangyf
 * @date 2022/12/1 22:09
 */
public class FindNearestPointThatHasTheSamexoryCoordinate1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int nearest = Integer.MAX_VALUE, idx = -1;
        for (int i=0; i<points.length; i++){
            if (points[i][0] == x){
                if (Math.abs(points[i][1] - y) < nearest){
                    nearest = Math.abs(points[i][1] - y);
                    idx = i;
                }
            }else if (points[i][1] == y){
                if (Math.abs(points[i][0] - x) < nearest){
                    nearest = Math.abs(points[i][0] - x);
                    idx = i;
                }
            }
        }
        return idx;
    }
}
