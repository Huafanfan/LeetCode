package byteDance;

public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int index = 1;
        int pre = 1;
        while (index < k){
            int count = getSubCount(pre, n);
            if (index + count > k){
                pre *= 10;
                index++;
            }else {
                pre += 1;
                index += count;
            }
        }
        return pre;
    }

    public int getSubCount(int prefix, int n){
        long cur = prefix;
        long next = prefix + 1;
        int count = 0;
        while (cur <= n){
            count += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
