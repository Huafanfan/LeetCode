package _10SubarraySum

func subarraySum(nums []int, k int) int {
	count := 0
	for start := 0; start < len(nums); start++ {
		sum := 0
		for end := start; end < len(nums); end++ {
			sum += nums[end]
			if sum == k {
				count++
			}
		}
	}
	return count
}

func subarraySum2(nums []int, k int) int {
	preSum := make([]int, len(nums)+1)
	preSum[0] = 0
	for i := 1; i <= len(nums); i++ {
		preSum[i] = preSum[i-1] + nums[i-1]
	}
	count := 0
	for left := 0; left < len(nums); left++ {
		for right := left; right < len(nums); right++ {
			if preSum[right+1]-preSum[left] == k {
				count++
			}
		}
	}
	return count
}
