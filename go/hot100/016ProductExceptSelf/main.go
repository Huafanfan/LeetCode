package _16ProductExceptSelf

func productExceptSelf(nums []int) []int {
	preNum := make([]int, len(nums))
	postNum := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		if i == 0 {
			preNum[i] = 1
		} else {
			preNum[i] = preNum[i-1] * nums[i-1]
		}
	}
	for i := len(nums) - 1; i >= 0; i-- {
		if i == len(nums)-1 {
			postNum[i] = 1
		} else {
			postNum[i] = postNum[i+1] * nums[i+1]
		}
	}
	res := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		res[i] = preNum[i] * postNum[i]
	}
	return res
}

func productExceptSel2(nums []int) []int {
	ans := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		if i == 0 {
			ans[i] = 1
		} else {
			ans[i] = ans[i-1] * nums[i-1]
		}
	}

	R := 1
	for i := len(nums) - 1; i >= 0; i-- {
		ans[i] *= R
		R *= nums[i]
	}
	return ans
}
