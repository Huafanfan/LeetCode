package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/11/24 22:16
 */
public class NumberOfSubarraysWithBoundedMaximum0795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //dp[i] 表示以i位置为最后一个元素的,满足条件的子数组的个数
        int [] dp = new int [nums.length];
        dp[0] = (nums[0] >= left && nums[0] <= right)? 1 : 0;
        //k指向遍历指针前面最后一次出现大于等于left的元素的坐标
        int k = (nums[0] >= left) ? 0 : -1;

        for (int i = 1; i < nums.length; i++) {
            //1.比right大 任何包含该元素为结尾的都不满足为0
            //2.比left小 第i-1 位置的那dp[i-1]个满足的子数组都可以带上 nums[i]
            //3.之间的：所求个数分三部分 a:i-1位置的情况续接 b:之前小于left的连续序列以nums[i]结尾 c:它自己成一个满足的子数组
            if (nums[i] > right) {
                dp[i] = 0;
            } else if (nums[i] < left) {
                dp[i] = dp[i - 1];
            } else {
                // (i - 1)表示i的前一个，(k + 1)表示k的后一个，((i - 1) - (k + 1) + 1) + 1表示他们之间的元素数量，他们中的每一个接上num[i]都满足题意
                dp[i] = dp[i - 1] + ((i - 1) - (k + 1) + 1) + 1;
            }

            //更新k的位置
            if (nums[i] >= left) {
                k = i;
            }
        }

        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarraysWithBoundedMaximum0795 n = new NumberOfSubarraysWithBoundedMaximum0795();
        int[] nums = new int[]{2,1,4,3};
        System.out.println(n.numSubarrayBoundedMax(nums, 2, 3));
    }
}
