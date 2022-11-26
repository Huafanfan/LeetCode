package acwing.algorithmimprovement.dp.backpack.acwing487;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/26 21:13
 */
public class Main {
    static int N = 70;
    static int M = 32010;
    static int[] f = new int[M];
    static int n,m;
    static PII[] master = new PII[N];
    static List<PII>[] servant = new ArrayList[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        for (int i=1; i<=n; i++){
            master[i] = new PII(0,0);
            servant[i] = new ArrayList<PII>();
        }
        for (int i=1; i<=n; i++){
            int v = in.nextInt();
            int w = in.nextInt();
            int p = in.nextInt();
            if (p == 0){
                master[i] = new PII(v, v*w);
            } else {
                servant[p].add(new PII(v, v*w));
            }
        }

        for (int i=1; i<=n; i++){
            for (int j=m; j>=0; j--){
                //一个背包表示的就是主件+附件的数量
                //因为我们最多有2个附件，所以可以用二进制的表示来表示选了多少个附件
                //比如00 01 10 11  各组含义就是一个没选，选了第一个，选了第二个，两个都选
                //首先将主件的体积跟价值拿出来，然后枚举所有可能，然后进行主件+附件

                //f[i][j] = f[i - 1][j]; //这是不选第i组背包

                //二进制，主件对应的附件的二进制枚举
                for (int k=0; k < 1<<servant[i].size(); k++){
                    int v = master[i].v;
                    int w = master[i].w;

                    for (int u=0; u<servant[i].size(); u++){
                        if ((k >> u & 1) == 1){
                            v += servant[i].get(u).v;
                            w += servant[i].get(u).w;
                        }
                    }
                    if (j >= v){
                        f[j] = Math.max(f[j], f[j-v] + w);
                    }
                }
            }
        }
        System.out.println(f[m]);
    }
}

class PII{
    int v, w;
    public PII(int v, int w){
        this.v = v;
        this.w = w;
    }
}
