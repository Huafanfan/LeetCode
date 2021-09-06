package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/6 09:30
 */
public class CorporateFlightBookings1109 {
    /**
     * 超时
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] booking : bookings){
            for (int i=booking[0]; i<=booking[1]; i++){
                int count = map.getOrDefault(i, 0);
                count += booking[2];
                map.put(i, count);
            }
        }
        int[] res = new int[n];
        for (int i=0; i<n; i++){
            res[i] = map.get(i + 1);
        }
        return res;
    }

    /**
     * 差分数组，用差分数组的前缀和来求每个航班的订票数
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] num = new int[n];
        for (int[] booking : bookings){
            num[booking[0] - 1] += booking[2];
            if (booking[1] < n){
                num[booking[1]] -= booking[2];
            }
        }
        for (int i=1; i<n; i++){
            num[i] += num[i-1];
        }
        return num;
    }
}
