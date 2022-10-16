package acwing.dynamicprogramming.digitaldp.acwing338;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yifan.zhangyf
 * @date 2022/10/16 17:01
 */
class Main{
    static int get(List<Integer> list, int l, int r){
        int res = 0;
        for(int i=l; i>=r; i--){
            res = res * 10 + list.get(i);
        }
        return res;
    }

    static int power10(int x){
        int res = 1;
        while(x!=0){
            res *= 10;
            x--;
        }
        return res;
    }

    /**
     * 统计从1-n，x出现的次数
     */
    static int count(int n, int x){
        if(n==0) {
            //如果n为0，那直接返回0就行了
            return 0;
        }
        List<Integer> l = new ArrayList<>();

        //将n的每一位加入到l中
        while(n!=0){
            l.add(n % 10);
            n /= 10;
        }
        int len = l.size();

        //对于0,不需要枚举最高位
        int res = 0;
        for(int i=len-1-(x==0?1:0); i>=0; i--){
            if(i < len-1){
                res += get(l, len-1, i+1) * power10(i);
                if(x == 0) {
                    res -= power10(i);
                }
            }

            if(l.get(i) > x) {
                res += power10(i);
            } else if(l.get(i) == x) {
                res += get(l, i-1, 0) + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = in.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        while(a!=0 || b!=0){
            if(a > b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            //枚举每一个数字
            for(int i=0; i<=9; i++){
                System.out.print(count(b, i)-count(a-1, i)+" ");
            }
            System.out.println();

            String[] cur = in.readLine().split(" ");
            a = Integer.parseInt(cur[0]);
            b = Integer.parseInt(cur[1]);
        }
    }
}
