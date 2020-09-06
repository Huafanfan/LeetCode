package com.huafanfan.easy;


/**
 * @author alex
 */
public class MaxSubArray0053 {

	public static void main(String[] args){
		int[] a = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArrayForce(a));
		System.out.println(maxSubArrayForcePrefix(a));
		System.out.println(maxSubArray(a));
		System.out.println(maxSubArrayDynamic(a));
		System.out.println(helper(a,0,a.length-1));
	}

	public static int maxSubArrayForce(int[] nums){
		int n = nums.length;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0;i<n;i++){
			sum = 0;
			for (int j = i; j < n; j++){
				sum += nums[j];
				maxSum = Math.max(sum,maxSum);
			}
		}
		return maxSum;
	}

	/*
	我们定义函数 S(i) ，它的功能是计算以 0（包括 0）开始加到 i（包括 i）的值。
	那么 S(j) - S(i - 1) 就等于 从 i 开始（包括 i）加到 j（包括 j）的值。
	我们进一步分析，实际上我们只需要遍历一次计算出所有的 S(i), 其中 i = 0,1,2....,n-1。
	然后我们再减去之前的 S(k),其中 k = 0，1，i - 1，中的最小值即可。 因此我们需要 用一个变量来维护这个最小值，
	还需要一个变量维护最大值。
	时间复杂度： O(n) - n 是数组长度
	空间复杂度： O(1)
	 */

	public static int maxSubArrayForcePrefix(int[] nums){
		int minSum = 0;
		int sum = 0;
		int maxSum = nums[0];
		for (int num:nums){
			sum += num;
			maxSum = Math.max(maxSum,sum - minSum);
			minSum = Math.min(minSum,sum);
		}
		return maxSum;
	}

	/*
	动态规划
	时间复杂度：O(N)。只遍历了一次数组。
	空间复杂度：O(1)，使用了常数的空间。
	 */

	public static int maxSubArrayDynamic(int[] nums) {
		//int n = nums.length, maxSum = nums[0];
		//for(int i = 1; i < n; ++i) {
		//	if (nums[i - 1] > 0) {
		//		nums[i] += nums[i - 1];
		//	}
		//	maxSum = Math.max(nums[i], maxSum);
		//}
		//return maxSum;
		int currMaxSum = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, currMaxSum);
		}
		return maxSum;
	}

	/*
	 * 贪心算法
	 * 时间复杂度：O(N)。只遍历一次数组。
	 * 空间复杂度：O(1)，只使用了常数空间。
	 */

	public static int maxSubArray(int [] nums) {

		int length = nums.length;
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums [j];
		        maxSum =  Math.max(maxSum,sum);
			}
		}
		return maxSum;
	}

	/*
	 * 分治法
	 * 时间复杂度：O(NlogN)。
	 * 空间复杂度：O(logN)，递归时栈使用的空间。
	 */

	public static int crossSum(int[] nums, int left, int right, int p) {
	    if (left == right) {
			return nums[left];
		}

	    int leftSubsum = Integer.MIN_VALUE;
	    int currSum = 0;
	    for(int i = p; i > left - 1; --i) {
	      currSum += nums[i];
	      leftSubsum = Math.max(leftSubsum, currSum);
	    }

	    int rightSubsum = Integer.MIN_VALUE;
	    currSum = 0;
	    for(int i = p + 1; i < right + 1; ++i) {
	      currSum += nums[i];
	      rightSubsum = Math.max(rightSubsum, currSum);
	    }

	    return leftSubsum + rightSubsum;
	  }
	public static int helper(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}

	    int p = (left + right) / 2;

	    int leftSum = helper(nums, left, p);
	    int rightSum = helper(nums, p + 1, right);
	    int crossSum = crossSum(nums, left, right, p);

	    return Math.max(Math.max(leftSum, rightSum), crossSum);
	  }
}
