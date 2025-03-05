package _14Merge

import (
	"math"
	"sort"
)

func merge(intervals [][]int) [][]int {
	if len(intervals) <= 1 {
		return intervals
	}
	res := make([][]int, 0)
	cur := intervals[0]
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	for i := 1; i < len(intervals); i++ {
		if cur[1] < intervals[i][0] {
			res = append(res, cur)
			cur = intervals[i]
		} else {
			cur[1] = int(math.Max(float64(cur[1]), float64(intervals[i][1])))
		}
	}
	res = append(res, cur)
	return res
}
