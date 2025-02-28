package _09FindAnagrams

func findAnagrams(s string, p string) []int {
	m := make(map[[26]int]int)
	k := [26]int{}
	for _, v := range p {
		k[v-'a']++
	}
	m[k] = 1
	ans := make([]int, 0)
	for i := 0; i < len(s); i++ {
		k := [26]int{}
		for j := i; j < len(s) && j-i < len(p); j++ {
			k[s[j]-'a']++
		}
		if m[k] == 1 {
			ans = append(ans, i)
		}
	}
	return ans
}

func findAnagrams2(s string, p string) (ans []int) {
	sLen, pLen := len(s), len(p)
	if sLen < pLen {
		return
	}

	var sCount, pCount [26]int
	for i := range p {
		sCount[s[i]-'a']++
		pCount[p[i]-'a']++
	}
	if sCount == pCount {
		ans = append(ans, 0)
	}

	for i := range s[:sLen-pLen] {
		sCount[s[i]-'a']--
		sCount[s[i+pLen]-'a']++
		if sCount == pCount {
			ans = append(ans, i+1)
		}
	}
	return
}
