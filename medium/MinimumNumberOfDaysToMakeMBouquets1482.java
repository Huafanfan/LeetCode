package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/11 10:23
 */
public class MinimumNumberOfDaysToMakeMBouquets1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length){
            return -1;
        }
        int minDay = Integer.MAX_VALUE;
        int maxDay = 0;
        for (int bloom : bloomDay){
            minDay = Math.min(bloom, minDay);
            maxDay = Math.max(bloom, maxDay);
        }
        while (minDay < maxDay){
            int mid = minDay + (maxDay - minDay) / 2;
            if (!check(bloomDay, mid, m, k)){
                minDay = mid + 1;
            }
            else {
                maxDay = mid;
            }
        }
        return maxDay;
    }

    private boolean check(int[] bloomDay, int day, int m, int k){
        int count = 0;
        int flowerCount = 0;
        for (int i=0; i<bloomDay.length && count < m; i++) {
            if (bloomDay[i] <= day) {
                flowerCount++;
                if (flowerCount == k) {
                    count++;
                    flowerCount = 0;
                }
            } else {
                flowerCount = 0;
            }
        }
        return count == m;
    }

    public static void main(String[] args) {
        MinimumNumberOfDaysToMakeMBouquets1482 minimumNumberOfDaysToMakeMBouquets1482 = new MinimumNumberOfDaysToMakeMBouquets1482();
        int[] bloomDay = new int[]{1,10,2,9,3,8,4,7,5,6};
        System.out.println(minimumNumberOfDaysToMakeMBouquets1482.minDays(bloomDay, 4, 2));
    }
}
