package hard;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/28 09:17
 */
public class ReversePairs0493 {
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                long temp = 2L * nums[j];
                if (nums[i] > temp) {
                    count++;
                }
            }
        }
        return count;
    }

    public int reversePairs2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length-1);
    }

    public int reversePairsRecursive(int[] nums, int left, int right) {
        if (right == left){
            return 0;
        }else {
            int mid = (left + right) / 2;
            int n1 = reversePairsRecursive(nums, left, mid);
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                ret += j - (mid + 1);
                i++;
            }

            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                }
                else if (p1 > right) {
                    sorted[p++] = nums[p1++];
                }
                else {
                    if (nums[p1] < nums[p2]){
                        sorted[p++] = nums[p1++];
                    }
                    else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            if (sorted.length >= 0) {
                System.arraycopy(sorted, 0, nums, left, sorted.length);
            }
            return ret;
        }
    }

    public int reversePairs3(int[] nums) {
        Set<Long> allNumbers = new TreeSet<Long>();
        for (int x : nums) {
            allNumbers.add((long) x);
            allNumbers.add((long) x * 2);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BIT bit = new BIT(values.size());
        for (int i = 0; i < nums.length; i++) {
            int left = values.get((long) nums[i] * 2), right = values.size() - 1;
            ret += bit.query(right + 1) - bit.query(left + 1);
            bit.update(values.get((long) nums[i]) + 1, 1);
        }
        return ret;
    }

    public int reversePairs4(int[] nums) {
        List<Long> list = new ArrayList<>();
        int count = 0;
        for (int i = nums.length-1; i>=0; i--){
            if (list.contains(nums[i])){
                count += list.indexOf(nums[i]);
            }
            long n2 = 2L * nums[i];
            list.add(n2);
            Collections.sort(list);
        }
        return count;
    }

    public static void main(String[] args) {
        ReversePairs0493 reversePairs0493 = new ReversePairs0493();
        int[] nums = new int[]{1,3,2,3,1};
        System.out.println(reversePairs0493.reversePairs3(nums));
    }
}

class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x, int d) {
        while (x <= n) {
            tree[x] += d;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x != 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }
}
