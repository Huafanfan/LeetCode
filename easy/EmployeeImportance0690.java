package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/1 10:28
 */
public class EmployeeImportance0690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees){
            map.put(e.id, e);
        }
        return getCurrentImportance(id, map);
    }

    public int getCurrentImportance(int id, Map<Integer, Employee> map){
        int res = map.get(id).importance;
        for (int e : map.get(id).subordinates){
            res += getCurrentImportance(e, map);
        }
        return res;
    }
}
