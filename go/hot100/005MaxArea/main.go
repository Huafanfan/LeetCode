package _05MaxArea

import "math"

func maxArea(height []int) int {
	maxArea := 0
	i := 0
	j := len(height) - 1
	for i < j {
		currentArea := int(math.Min(float64(height[i]), float64(height[j]))) * (j - i)
		if currentArea > maxArea {
			maxArea = currentArea
		}
		if height[i] < height[j] {
			i++
		} else {
			j--
		}
	}
	return maxArea
}
