package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/10 10:43
 */
public class CapacitytoShipPackageswithinDDays1011 {
    public int shipWithinDays(int[] weights, int D) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low < high){
            int mid = (high + low) / 2;
            if (canShip(weights, mid, D)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean canShip(int[] weights, int capacity, int D){
        int current = capacity;
        for (int weight : weights){
            if (weight > capacity){
                return false;
            }
            if (current < weight){
                current = capacity;
                D--;
            }
            current -= weight;
        }
        return D>0;
    }
}
