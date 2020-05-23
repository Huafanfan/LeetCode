package com.huafanfan.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/23 10:51
 */
public class RemovePalindromicSubsequences1332 {
    public int removePalindromeSub(String s) {
        if ("".equals(s)){
            return 0;
        }
        for (int start=0,end=s.length()-1;start<end;start++,end--){
            if(s.charAt(start)!=s.charAt(end)){
                return 2;
            }
        }
        return 1;
    }
}
