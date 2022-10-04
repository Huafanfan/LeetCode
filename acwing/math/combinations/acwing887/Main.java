package acwing.math.combinations.acwing887;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yifan.zhangyf
 * @date 2022/10/4 18:03
 */
class Main{
    static int p;

    static int qmi(int a, int b){
        int res = 1 % p;
        while(b!=0){
            if(b%2!=0) {
                res = (int) ((long)res*a%p);
            }
            a = (int) ((long)a*a%p);
            b/=2;
        }
        return res;
    }

    static int C(long a, long b){
        int res = 1;
        for(int i=1, j=(int)a; i<=b; i++, j--){
            res = (int) ((long)res*j%p) ;
            res = (int) ((long)res*qmi(i, p-2)%p);
        }
        return res;
    }//根据定义求C(a, b)

    //lucas定理
    static int lucas(long a, long b){
        if(a<p && b<p){
            return C(a, b);
        }
        return (int) ((long)lucas(a/p, b/p)*C(a%p, b%p) % p);
    }

    public static void main(String[]args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());
        while(n-->0){
            String[]arr=in.readLine().split(" ");
            long a=Long.parseLong(arr[0]);
            long b=Long.parseLong(arr[1]);
            p=Integer.parseInt(arr[2]);

            System.out.println(lucas(a,b));
        }
    }
}
