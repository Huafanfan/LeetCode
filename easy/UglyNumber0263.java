package com.huafanfan.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/21 10:38
 */
public class UglyNumber0263 {
    public boolean isUgly(int num) {
        if (num<1) {
            return false;
        }
        while (num%5==0){
            num/=5;
        }
        if (num==1){
            return true;
        }
        while (num%3==0){
            num/=3;
        }
        if (num==1){
            return true;
        }
        while ((num & 1) == 0){
            num>>=1;
        }
        return num == 1;
    }
}
