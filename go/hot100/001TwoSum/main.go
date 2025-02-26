package main

func main() {
	println("Hello, World!")
}

func twoSum(nums []int, target int) []int {
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return []int{}
}

func twoSum2(nums []int, target int) []int {
	hash := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if j, ok := hash[target-nums[i]]; ok {
			return []int{i, j}
		}
		hash[nums[i]] = i
	}
	return []int{}
}
