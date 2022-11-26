package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yifan.zhangyf
 * @date 2022/11/23 23:06
 */
public class MaximumNumberOfBallsInABox1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i=lowLimit; i<=highLimit; i++){
            int index = 0;
            int tmp = i;
            while (tmp != 0){
                index += tmp % 10;
                tmp /= 10;
            }
            if (index != 0){
                map.put(index, map.getOrDefault(index, 0) + 1);
                if (map.get(index) > max){
                    max = map.get(index);
                }
            }
        }
        return max;
    }
}
