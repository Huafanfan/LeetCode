package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/3 11:49
 */
public class BrickWall0554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> widths : wall){
            int sum = 0;
            int size = widths.size();
            for (int i=0; i<size - 1; i++){
                sum += widths.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }
}
