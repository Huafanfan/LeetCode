package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/19 09:00
 */
public class GrayCode0089 {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        //初始化 n = 0 的解
        gray.add(0);
        for (int i = 0; i < n; i++) {
            //要加的数
            int add = 1 << i;
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    public static void main(String[] args) {
        GrayCode0089 grayCode0089 = new GrayCode0089();
        System.out.println(grayCode0089.grayCode(3));
    }
}
