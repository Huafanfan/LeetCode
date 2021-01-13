package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/13 11:05
 */
public class RedundantConnection0684 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parents = new int[len + 1];
        for (int i=1; i<=len; i++){
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (find(parents, edge[0]) != find(parents, edge[1])) {
                union(parents, edge[0], edge[1]);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public int find(int[] parents, int i){
        if (parents[i] != i){
            parents[i] = find(parents, i);
        }
        return parents[i];
    }

    public void union(int[] parents, int i, int j){
        parents[find(parents, i)] = parents[j];
    }
}
