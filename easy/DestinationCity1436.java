package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/1 16:21
 */
public class DestinationCity1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> path : paths){
            map.put(path.get(0), map.getOrDefault(path.get(0), 0) + 1);
            map.put(path.get(1), map.getOrDefault(path.get(1), 0));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() == 0){
                return entry.getKey();
            }
        }
        return "";
    }

    public String destCity2(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<String>();
        for (List<String> path : paths) {
            citiesA.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!citiesA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
