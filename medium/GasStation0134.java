package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/18 09:35
 */
public class GasStation0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int N = gas.length;
        for (int i=0; i<N; i++){
            if (gas[i] >= cost[i]){
                start = i;
                if (isComplete(start, gas, cost, N)){
                    return start;
                }
            }
        }
        return -1;
    }

    public boolean isComplete(int start, int[] gas, int[] cost, int N) {
        int currentGas = 0;
        int currentIndex = start;
        for (int i = 0; i<N; i++){
            currentGas += gas[currentIndex];
            if (currentGas >= cost[currentIndex]){
                currentGas -= cost[currentIndex];
                currentIndex = (currentIndex + 1) % N;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation0134 gasStation0134 = new GasStation0134();
        //int[] gas = new int[]{1, 2, 3, 4, 5};
        //int[] cost = new int[]{3, 4, 5, 1, 2};
        int[] gas = new int[]{2};
        int[] cost = new int[]{2};
        System.out.println(gasStation0134.canCompleteCircuit(gas, cost));
    }
}
