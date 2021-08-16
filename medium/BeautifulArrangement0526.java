package medium;

import java.util.*;

public class BeautifulArrangement0526 {
    List<List<Integer>> match;
    int res;
    public int countArrangement(int n) {
        match = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            match.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match.get(i).add(j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        dfs(1, n, set);
        return res;
    }

    public void dfs(int index, int N, Set<Integer> set){
        if (index == N + 1){
            res++;
            return;
        }
        for (int x : match.get(index)){
            if (!set.contains(x)){
                set.add(x);
                dfs(index+1, N, set);
                set.remove(x);
            }
        }
    }

    public int countArrangement2(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];//mask ^ (1 << i)被选中位置置为0
                }
            }
        }
        return f[(1 << n) - 1];
    }

    public static void main(String[] args) {
        BeautifulArrangement0526 beautifulArrangement0526 = new BeautifulArrangement0526();
        System.out.println(beautifulArrangement0526.countArrangement(2));
    }
}
