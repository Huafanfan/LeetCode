package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 15:39
 */
public class MaximumSubarray0053 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int sum = nums[0];
        for (int i=1; i<len; i++){
            if (sum>0){
                sum += nums[i];
            }
            else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public class Status {
        //lSum 表示 [l,r] 内以 l 为左端点的最大子段和
        //rSum 表示 [l,r] 内以 r 为右端点的最大子段和
        //mSum 表示 [l,r] 内的最大子段和
        //iSum 表示 [l,r] 的区间和
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray2(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
