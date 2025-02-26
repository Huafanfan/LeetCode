package _02GroupAnagrams

import "sort"

func groupAnagrams(strs []string) [][]string {
	mp := make(map[string][]string)
	for _, str := range strs {
		bytes := []byte(str)
		sort.Slice(bytes, func(i, j int) bool {
			return bytes[i] < bytes[j]
		})
		mp[string(bytes)] = append(mp[string(bytes)], str)
	}
	result := make([][]string, 0, len(mp))
	for _, strs := range mp {
		result = append(result, strs)
	}
	return result
}

func groupAnagrams2(strs []string) [][]string {
	mp := make(map[[26]int][]string)
	for _, str := range strs {
		bytes := []byte(str)
		key := [26]int{}
		for _, b := range bytes {
			key[b-'a']++
		}
		mp[key] = append(mp[key], str)
	}
	result := make([][]string, 0, len(mp))
	for _, strs := range mp {
		result = append(result, strs)
	}
	return result
}
