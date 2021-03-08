package bishi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/6 09:46
 */
public class Solution {
    //public int solution(int A, int B, int C, int D) {
    //    int max;
    //
    //    max = distance(A, B, C, D);
    //
    //    int dis2 = distance(A, B, D, C);
    //    max = Math.max(max, dis2);
    //
    //    int dis3 = distance(A, C, D, B);
    //    max = Math.max(max, dis3);
    //    return max;
    //}
    //
    //public int distance(int point1X, int point1Y, int point2X, int point2Y){
    //    return (int) (Math.pow(Math.abs(point1X - point2X), 2) + Math.pow(Math.abs(point1Y - point2Y), 2));
    //}

    //public int solution(int[] X, int[] Y) {
    //    int res = 0;
    //    Map<String, Integer> map = new HashMap<>();
    //    int len = X.length;
    //    for (int i=0; i<len; i++){
    //        int max = maxCommon(X[i], Y[i]);
    //        String num = X[i] / max + "/" + Y[i] / max;
    //        map.put(num, map.getOrDefault(num, 0) + 1);
    //    }
    //    for (Map.Entry<String, Integer> entry : map.entrySet()){
    //        String num1 = entry.getKey();
    //        for (Map.Entry<String, Integer> entry2 : map.entrySet()){
    //            String num2 = entry2.getKey();
    //            if (!num1.equals(num2)){
    //                if (mulit(num1, num2)){
    //                    res += entry.getValue() * entry2.getValue();
    //                    entry.setValue(0);
    //                    entry2.setValue(0);
    //                }
    //            }
    //            else {
    //                if (mulit(num1, num2)){
    //                    int value = entry.getValue() - 1;
    //                    int sum = 0;
    //                    while (value > 0){
    //                        sum += value;
    //                        value--;
    //                    }
    //                    res += sum;
    //                    entry.setValue(0);
    //                }
    //            }
    //        }
    //    }
    //    return res;
    //}
    //
    //public boolean mulit(String num1, String num2){
    //    int numerator1 = Integer.parseInt(num1.split("/")[0]);
    //    int denomiator1 = Integer.parseInt(num1.split("/")[1]);
    //    int numerator2 = Integer.parseInt(num2.split("/")[0]);
    //    int denomiator2 = Integer.parseInt(num2.split("/")[1]);
    //
    //    int max = maxCommon(denomiator1, denomiator2);
    //    int min = denomiator1 * denomiator2 / max;
    //    return (numerator1 * min / denomiator1 + numerator2 * min / denomiator2) == max;
    //}
    //
    //public int maxCommon(int num1, int num2){
    //    while (num2 != 0){
    //        int tmp = num2;
    //        num2 = num1 % num2;
    //        num1 = tmp;
    //    }
    //    return num1;
    //}

    //public static void main(String[] args) {
    //    int[] X = new int[]{1, 2, 3, 1, 2, 12, 8, 4, 1};
    //    int[] Y = new int[]{5, 10, 15, 2, 4, 15, 10, 5, 2};
    //    Solution solution = new Solution();
    //    solution.solution(X, Y);
    //}

    //public int solution(int[] A) {
    //    int res = 0;
    //    int len = A.length;
    //    Arrays.sort(A);
    //    for (int i=0; i<len; i++){
    //        res += Math.abs(A[i] - i + 1);
    //    }
    //    return res;
    //}

}
