package acwing.datastructure.trie.acwing835;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/4 4:50 PM
 */
public class Main {
    static int N  = 100010;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N]; //已当前这个点结束的字符串有多少个
    static int idx; // 当前用到的下标。 下标是0的点，既是根节点，又是空节点。

    static void insert(char[] str){
        int p = 0;
        for (int i=0; i<str.length; i++){
            int u = str[i] - 'a';
            if (son[p][u] == 0){
                son[p][u] = ++ idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    static int query(char[] str){
        int p = 0;
        for (int i=0; i<str.length; i++){
            int u = str[i] - 'a';
            if (son[p][u] == 0){
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- > 0){
            String cmd = in.next();
            if ("I".equals(cmd)){
                insert(in.next().toCharArray());
            } else {
                System.out.println(query(in.next().toCharArray()));
            }
        }
    }
}
