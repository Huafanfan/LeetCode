package hard;

public class DivideChocolate1231 {
    public int maximizeSweetness(int[] sweetness, int K) {
        if (sweetness.length < K + 1) {
            return -1;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (canSplit(sweetness, mid, K)){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    private boolean canSplit(int[] sweetness, int minSweet, int K){
        int count = 0;
        int sum = 0;
        for (int sweet : sweetness){
            sum += sweet;
            if (sum > minSweet){
                count++;
                sum = 0;
            }
        }
        return count >= K + 1;
    }
}
