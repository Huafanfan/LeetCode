package acwing.datastructure.monotonicqueue.acwing154;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/3 6:26 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int[] minQ = new int[n];
        int[] maxQ = new int[n];
        int minHH=0, minTT=-1;
        int maxHH=0, maxTT=-1;
        List<Integer> minAns = new ArrayList<>();
        List<Integer> maxAns = new ArrayList<>();
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
            if (minHH <= minTT && minQ[minHH] < i-k+1){
                minHH++;
            }
            while (minHH <= minTT && a[minQ[minTT]] >= a[i]){
                minTT--;
            }
            minQ[++minTT] = i;


            if (maxHH <= maxTT && maxQ[maxHH] < i-k+1){
                maxHH++;
            }
            while (maxHH <= maxTT && a[maxQ[maxTT]] <= a[i]){
                maxTT--;
            }
            maxQ[++maxTT] = i;

            if (i >= k - 1){
                System.out.print(a[minQ[minHH]] + " ");
                maxAns.add(a[maxQ[maxHH]]);
            }
        }

        System.out.println();

        for (int num : maxAns) {
            System.out.print(num + " ");
        }
    }
}
