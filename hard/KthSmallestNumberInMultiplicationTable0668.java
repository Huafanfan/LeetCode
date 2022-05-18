package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/18 09:58
 */
public class KthSmallestNumberInMultiplicationTable0668 {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r){
            int mid = (r + l) >> 1;

            int count = 0;
            int i = mid / n;
            count += i * n;
            for (i++; i<=m; i++){
                count += mid / i;
            }
            if (count >= k){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        KthSmallestNumberInMultiplicationTable0668 a = new KthSmallestNumberInMultiplicationTable0668();
        System.out.println(a.findKthNumber(3, 3, 5));
    }
}
