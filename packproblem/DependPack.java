package packproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/10 16:50
 */
public class DependPack {
    int[][] f = new int[110][110];
    List<List<Integer>> g = new ArrayList<>(110);
    int[] v = new int[110];
    int[] w = new int[110];
    int n,m,root;
    public void dfs(int x) {
        for(int i=v[x];i<=m;i++) {
            //点x必须选，所以初始化f[x][v[x] ~ m]= w[x]
            f[x][i]=w[x];
        }
        for(int i=0;i<g.get(x).size();i++)
        {
            int y=g.get(x).get(i);
            dfs(y);
            //j的范围为v[x]~m, 小于v[x]无法选择以x为子树的物品
            for(int j=m;j>=v[x];j--)
            {
                //分给子树y的空间不能大于j-v[x],不然都无法选根物品x
                for(int k=0;k<=j-v[x];k++)
                {
                    f[x][j]=Math.max(f[x][j],f[x][j-k]+f[y][k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        DependPack dependPack = new DependPack();
        Scanner sc=new Scanner(System.in);
        dependPack.n = sc.nextInt();
        dependPack.m = sc.nextInt();
        for(int i=1;i<=dependPack.n;i++)
        {
            int fa;
            dependPack.v[i] = sc.nextInt();
            dependPack.w[i] = sc.nextInt();
            fa = sc.nextInt();
            if(fa==-1) {
                dependPack.root=i;
            } else {
                List<Integer> temp = dependPack.g.get(fa);
                if (temp == null){
                    temp = new ArrayList<>();
                }
                temp.add(i);
                dependPack.g.add(fa,temp);
            }
        }
        dependPack.dfs(dependPack.root);
        System.out.println(dependPack.f[dependPack.root][dependPack.m]);
    }
}
