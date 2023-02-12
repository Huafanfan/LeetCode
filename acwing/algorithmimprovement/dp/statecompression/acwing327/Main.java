package acwing.algorithmimprovement.dp.statecompression.acwing327;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/4 12:11
 */
public class Main {
    static int N = 14, M = 1 << 12, mod = (int)1e8;
    static int n, m;
    static int[] g = new int[M];
    /**
    * 所有合法状态
    */
    static List<Integer> state = new ArrayList<>();

    /**
    * 每个状态(下标)可以转移到的其他的状态(下标)
    */
    static ArrayList<Integer>[] head = new ArrayList[M];

    static long[][] f = new long[N][M];

    /**
    * 检查是否存在两个连续的1
    * @param state
    * @return
    */
    static boolean check(int state) {
        for (int i=0; i<m; i++){
            if ((state >> i & 1) == 1 && (state >> i + 1 & 1) == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=0; j<m; j++){
                int t = in.nextInt();
                //g[i] += (1 - t) << j;  也可以这么写
                //为什么这样写呢，这样的存储是什么样的呢  就距离第一行就行，这是以行为单位的
                //举例最后输入的最后一行  010     ，然后我们存一下0的位置就存成1，g[1] = 101
                //然后我们下面枚举的合法状态，最后判断一下合法状态是不是成立的，
                //跟这个g[i]进行 & 操作 ，然后如果两个位置重叠都是1，的话就会&成1，
                //然后一个有1一个没有1，&完之后就是0，所以最后dp的时候判断一下是不是为0
                //&完之后是0就是合法状态，不会冲突，种在不孕不育的土地上

                //!t ==> t^1  0变1  0 - > 1   1变0 1 - > 0
                g[i] += (t ^ 1) << j;
                //我们自定义一下土地，将所有0跟1反过来表示一下，1是不孕，0是可种植
                //这样方便后面进行&操作
            }
        }

        for (int i=0; i< 1<<m; i++){
            if (check(i)){
                state.add(i);
            }
        }

        for (int i=0; i<state.size(); i++){
            for (int j=0; j<state.size(); j++){
                int a = state.get(i), b = state.get(j);
                if ((a & b) == 0){
                    if (head[i] == null){
                        head[i] = new ArrayList<>();
                    }
                    head[i].add(j);
                }
            }
        }

        f[0][0] = 1;
        //还是运用上一题的小技巧，枚举多一行，然后输出这样多枚举的这一行
        //答案就会是上面的最大值
        for (int i=1; i<=n+1; i++){
            for (int a=0; a<state.size(); a++){
                for (Integer b : head[a]){
                    if ((g[i] & state.get(a)) == 0){
                        f[i][a] = (f[i][a] + f[i-1][b]) % mod;
                    }
                }
            }
        }

        System.out.println(f[n+1][0]);

    }
}
