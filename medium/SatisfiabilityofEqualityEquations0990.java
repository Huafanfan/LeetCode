package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/7 15:03
 */
public class SatisfiabilityofEqualityEquations0990 {
    public boolean equationsPossible(String[] equations) {
        int equationsSize = equations.length;
        UnionFind unionFind = new UnionFind(equationsSize * 2);
        Map<String, Integer> map = new HashMap<>(equationsSize * 2);
        int id = 0;
        for (String equation : equations) {
            if (equation.contains("==")) {
                String var1 = equation.split("==")[0];
                String var2 = equation.split("==")[1];
                if (!map.containsKey(var1)) {
                    map.put(var1, id++);
                }
                if (!map.containsKey(var2)) {
                    map.put(var2, id++);
                }
                unionFind.union(map.get(var1), map.get(var2));
            }
        }

        for (String equation : equations){
            if (equation.charAt(1) == '!') {
                String var1 = equation.split("!=")[0];
                String var2 = equation.split("!=")[1];
                Integer id1 = map.get(var1);
                Integer id2 = map.get(var2);
                if (var1.equals(var2)||(id1 != null && id2 != null && unionFind.isConected(id1, id2))){
                    return false;
                }
            }
            //else {
            //
            //}
        }
        return true;
    }

    private class UnionFind {
        private int[] parent;

        public UnionFind(int n){
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }

        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }

    }
}
