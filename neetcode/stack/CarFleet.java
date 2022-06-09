package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/9 11:30
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1){
            return 1;
        }
        int[][] cars = new int[position.length][2];
        for (int i=0; i<position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        Deque<int[]> deque = new ArrayDeque<>();
        for (int[] car : cars) {
            if (deque.isEmpty()) {
                deque.push(car);
            } else {
                if (1.0 * (target - car[0]) / car[1] > 1.0 * (target - deque.peek()[0]) / deque.peek()[1]) {
                    deque.push(car);
                }
            }
        }
        return deque.size();
    }
}
