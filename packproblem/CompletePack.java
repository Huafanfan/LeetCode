package packproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/6 11:50
 */
public class CompletePack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] v=new int[N];
        int[] w=new int[N];
        for(int i=0;i<N;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        List<Integer> splitV = new ArrayList<>();
        List<Integer> splitW = new ArrayList<>();
        for (int i=0; i<N; i++){
            int weight = 0;
            int k = 0;
            //提升为 O(log ⌊ V /Ci ⌋ )
            while (v[i]* (weight =pow(2, k)) <= V){
                    splitV.add(v[i]*weight);
                    splitW.add(w[i]*weight);
                    k++;
            }
            //int splitNum = V/v[i];
            //for (int j=1; j<=splitNum; j++){
            //    splitV.add(v[i]);
            //    splitW.add(w[i]);
            //}
        }
        N = splitV.size();
        int[] dp=new int[V+1];
        for(int i=1;i<=N;i++){
            for (int j=V; j>=splitV.get(i-1); j--){
                dp[j] = Math.max(dp[j], dp[j-splitV.get(i-1)] + splitW.get(i-1));
            }
        }
        System.out.println(dp[V]);
    }

    public static int pow(int num, int k){
        int result = 1;
        while (k>0){
            result *= num;
            k--;
        }
        return result;
    }
}
