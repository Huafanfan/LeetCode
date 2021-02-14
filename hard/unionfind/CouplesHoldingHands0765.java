package hard.unionfind;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 14:08
 */
public class CouplesHoldingHands0765 {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len/2;
        UnionFind unionFind = new UnionFind(N);
        for (int i=0; i<len; i+=2){
            unionFind.union(row[i]/2, row[i+1]/2);
        }
        return N - unionFind.count;
    }

    class UnionFind {
        int[] parent;
        int count ;
        public UnionFind(int n){
            parent = new int[n];
            for (int i=0; i<n; i++){
                parent[i] = i;
            }
            count = n;
        }

        public int find(int n){
            if (n != parent[n]){
                parent[n] = find(parent[n]);
            }
            return parent[n];
        }

        public void union(int m, int n){
            int rootM = find(m);
            int rootN = find(n);
            if (rootM != rootN){
                parent[rootM] = rootN;
                count--;
            }
        }
    }
}
