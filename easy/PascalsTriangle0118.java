package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/6 09:18
 */
public class PascalsTriangle0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows==0){
            return triangle;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        triangle.add(row1);
        if (numRows==1){
            return triangle;
        }
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        triangle.add(row2);
        if (numRows==2){
            return triangle;
        }
        for (int i=2; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j=1; j<i; j++){
                row.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle0118 pascalsTriangle0118 = new PascalsTriangle0118();
        System.out.println(pascalsTriangle0118.generate(5));
    }
}
