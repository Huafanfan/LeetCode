package _08LengthOfLongestSubstring

func lengthOfLongestSubstring(s string) int {
	maxLength := 0
	right := -1
	m := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		if i != 0 {
			delete(m, s[i-1])
		}
		for right+1 < len(s) && m[s[right+1]] == 0 {
			m[s[right+1]]++
			right++
		}
		maxLength = max(maxLength, right-i+1)
	}
	return maxLength
}
