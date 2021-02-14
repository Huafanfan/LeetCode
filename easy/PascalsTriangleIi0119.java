package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 15:14
 */
public class PascalsTriangleIi0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        if (rowIndex == 0){
            return res;
        }
        res.add(1);
        if (rowIndex == 1){
            return res;
        }
        for (int i=2; i<=rowIndex; i++){
            res.add(i, 1);
            for (int j=i-1; j>=1; j--){
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangleIi0119 pascalsTriangleIi0119 = new PascalsTriangleIi0119();
        System.out.println(pascalsTriangleIi0119.getRow(4));
    }
}
