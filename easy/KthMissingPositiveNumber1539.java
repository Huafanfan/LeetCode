package easy;

public class KthMissingPositiveNumber1539 {
    public int findKthPositive(int[] arr, int k) {
        int missCount = 0, lastMiss = -1, current = 1, ptr = 0;
        for (missCount = 0; missCount < k; ++current) {
            if (current == arr[ptr]) {
                ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
            } else {
                ++missCount;
                lastMiss = current;
            }
        }
        return lastMiss;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber1539 kthMissingPositiveNumber1539 = new KthMissingPositiveNumber1539();
        int[] arr = new int[]{2,3,4,7,11};
        System.out.println(kthMissingPositiveNumber1539.findKthPositive(arr, 5));
    }
}
