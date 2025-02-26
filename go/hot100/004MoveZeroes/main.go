package _04MoveZeroes

func moveZeroes(nums []int) {
	i := 0
	j := 0
	for j < len(nums) {
		if nums[j] != 0 {
			nums[i], nums[j] = nums[j], nums[i]
			i++
		}
		j++
	}
}
