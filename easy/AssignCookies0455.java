package com.huafanfan;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/22 14:17
 */
public class AssignCookies0455 {
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        int count=0;
        for (int value : g) {
            for (; j < s.length; j++) {
                if (value <= s[j]) {
                    j++;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        while (i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
