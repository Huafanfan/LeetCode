package acwing.greedy.interval.acwing907;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * @author yifan.zhangyf
 */
public class Main{
    static class Range{
        int l,r;
        public Range(int l,int r){
            this.l = l;
            this.r = r;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int st = scan.nextInt();
        int ed = scan.nextInt();
        int n = scan.nextInt();
        Range[] range = new Range[n];
        for(int i = 0 ; i < n ; i ++ ){
            int l = scan.nextInt();
            int r = scan.nextInt();
            range[i] = new Range(l,r);
        }
        Arrays.sort(range, Comparator.comparingInt(o -> o.l));

        //答案
        int res = 0;
        //表示成功
        boolean success = false;
        // 使用双指针算法，来查找每个 <= st的右端点最长的数
        for(int i = 0 ; i < n ; i ++ ){
            int j = i;
            int end = (int)-(2e9);
            // 将所有左端点小于st的数的右端点进行比较，取出最大值
            while(j < n && range[j].l <= st){
                end = Math.max(end,range[j].r);
                j ++ ;
            }

            //如果右端点最大的点还小于st的话，就说明覆盖不完整，无解了break
            if(end < st) {
                break;
            }

            // 进行到这里就是有一个区间了 +1
            res ++;

            // 如果进行到这一步完全覆盖了，就标记一下，然后break
            if(end >= ed){
                success = true;
                break;
            }
            //没选取一个区间，就将st赋值成这个区间的右端;
            st = end;
            //然后将因为我们j是判断了所有的第一个可以选的区间，
            //所以将这些都不用看了，直接从j开始看，i= j，因为是从0开始的，所以就赋值成j - 1
            i = j - 1;
        }
        //如果没有标记就是说明没有完全覆盖，将结果复制成-1
        if(!success) {
            res = -1;
        }
        System.out.println(res);
    }
}
