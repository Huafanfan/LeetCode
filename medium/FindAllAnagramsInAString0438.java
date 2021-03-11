package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString0438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m<n){
            return res;
        }
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i=0; i<n; i++){
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArr, pArr)){
            res.add(0);
        }
        int left = 0;
        int right = n-1;
        while (right < m-1){
            sArr[s.charAt(left++) - 'a']--;
            sArr[s.charAt(++right) - 'a']++;
            if (Arrays.equals(sArr, pArr)){
                res.add(left);
            }

        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) {
            return res;
        }

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a'] ++;
        }

        int left = 0;
        for(int right = 0; right < n; right++){
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            while(sCnt[curRight] > pCnt[curRight]){
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            if(right - left + 1 == m){
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //s: "cbaebabacd" p: "abc"
        FindAllAnagramsInAString0438 findAllAnagramsInAString0438 = new FindAllAnagramsInAString0438();
        System.out.println(findAllAnagramsInAString0438.findAnagrams2("cbaebabacd", "abc"));
    }
}
