package _12MinWindow

import "math"

func minWindow(s string, t string) string {
	ori, cnt := map[byte]int{}, map[byte]int{}
	for i := range t {
		ori[t[i]]++
	}

	minLength := math.MaxInt32
	ansL, ansR := -1, -1

	check := func() bool {
		for k, v := range ori {
			if cnt[k] < v {
				return false
			}
		}
		return true
	}

	for l, r := 0, 0; r < len(s); r++ {
		if ori[s[r]] > 0 {
			cnt[s[r]]++
		}
		for check() && l < r {
			if r-l+1 < minLength {
				minLength = r - l + 1
				ansL, ansR = l, l+minLength
			}
			if _, ok := ori[s[l]]; ok {
				cnt[s[l]]--
			}
			l++
		}
	}
	if ansL == -1 {
		return ""
	}
	return s[ansL:ansR]
}
