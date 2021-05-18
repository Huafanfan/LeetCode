package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/18 16:04
 */
public class IntegerToRoman0012 {
    int I = 1;
    int IV = 4;
    int V = 5;
    int IX = 9;
    int X = 10;
    int XL = 40;
    int L = 50;
    int XC = 90;
    int C = 100;
    int CD = 400;
    int D = 500;
    int CM = 900;
    int M = 1000;
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num >= M){
            num -= M;
            res.append("M");
        }
        while (num >= CM){
            num -= CM;
            res.append("CM");
        }
        while (num >= D){
            num -= D;
            res.append("D");
        }
        while (num >= CD){
            num -= CD;
            res.append("CD");
        }
        while (num >= C){
            num -= C;
            res.append("C");
        }
        while (num >= XC){
            num -= XC;
            res.append("XC");
        }
        while (num >= L){
            num -= L;
            res.append("L");
        }
        while (num >= XL){
            num -= XL;
            res.append("XL");
        }
        while (num >= X){
            num -= X;
            res.append("X");
        }
        while (num >= IX){
            num -= IX;
            res.append("IX");
        }
        while (num >= V){
            num -= V;
            res.append("V");
        }
        while (num >= IV){
            num -= IV;
            res.append("IV");
        }
        while (num >= I){
            num -= I;
            res.append("I");
        }
        return res.toString();
    }
}
