package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/17 19:33
 */
public class KthSmallestInLexicographicalOrder0440 {
    public int findKthNumber(int n, int k) {
        int index = 1;
        int prefix = 1;
        while (index < k){
            int count = getSubCount(prefix, n);
            if (index + count > k){
                prefix *= 10;
                index++;
            }
            else {
                prefix += 1;
                index += count;
            }
        }
        return prefix;
    }

    public int getSubCount(int prefix, int n){
        long cur = prefix;
        long next = prefix+1;
        int count = 0;
        while (cur <= n){
            count += Math.min(n+1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println("a");
    }
}
