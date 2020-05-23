package com.huafanfan.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/2 10:49
 */
public class ValidPalindrome0125 {
    public boolean isPalindrome1(String s) {
        if(s==null){
            return false;
        }
        if(s.length()==0){
            return true;
        }
        StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]",""));
        return sb.toString().equals(sb.reverse().toString());
    }

    /**
     * 统一转成大写：ch & 0b11011111 简写：ch & 0xDF
     * 统一转成小写：ch | 0b00100000 简写：ch | 0x20
     */
    public boolean isPalindrome2(String s) {
        if(s==null){
            return false;
        }
        if(s.length()==0){
            return true;
        }
        s=s.replaceAll("[^a-zA-Z0-9]","");
        int i=0,j=s.length()-1;
        while (i<=j){
            if((s.charAt(i ++) & 0xDF) != (s.charAt(j --) & 0xDF)) {
                return false;
            }
        }
        return true;
    }

}
