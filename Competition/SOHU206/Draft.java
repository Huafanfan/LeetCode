package Competition.SOHU206;
import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/14 14:24
 */
public class Draft {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        int result = 0;
        for (int i=0; i<n; i++){
            if (row[i] == 0){
                for (int j=0; j<m; j++){
                    if (col[j] == 0){
                        if (mat[i][j]==1){
                            boolean flag = true;
                            for (int l=0; l<m; l++){
                                if (l!=j){
                                    if (mat[i][l]==1){
                                        flag = false;
                                        row[i] = 1;
                                    }
                                }
                            }
                            for (int l=0; l<n; l++){
                                if (l!=i){
                                    if (mat[l][j]==1){
                                        flag = false;
                                        col[j] = 1;
                                    }
                                }
                            }
                            if (flag){
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0],pair[1]);
            map.put(pair[1],pair[0]);
        }
        int result = 0;
        for (int x=0; x<n; x++){
            int y = map.get(x);
            for (int i=0; i<indexArray(preferences[x],y); i++){
                int u = preferences[x][i];
                int v = map.get(u);
                if (indexArray(preferences[u],x)<indexArray(preferences[u],v)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    public int indexArray(int[] array,int value){
        for(int i = 0;i<array.length;i++){
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }

    //并查集find数组
    int[] f ;
    public int find(int x) {//find函数，判断是否同一个root节点
        return f[x] == x ? x : find(f[x]);
    }
    public int minCostConnectPoints(int[][] points) {
        int h = points.length;
        f=new int[h+1];
        for (int i = 0; i < f.length; i++) {
            //初始化find数组，让初始每个节点都自成一个集合，互相不联通
            f[i]=i;
        }
        ArrayList<Edge> edges = new ArrayList<>();
        //求边长
        for (int i = 0; i < h; i++) {
            for (int j = i + 1; j < h; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (len != 0) {
                    edges.add(new Edge(i, j, len));
                }
            }
        }
        int ans =0;
        Collections.sort(edges);
        for(Edge e:edges){
            int x=e.getX();
            int y =e.getY();
            int len = e.getLen();
            if(find(x)==find(y)) {
                //如果两个节点是同一个集合中，说明之前已经有其他路径连过了
                continue;
            }
            ans+=len;
            f[find(x)] = find(y);
            //把两集合合并
        }
        return ans;
    }

}

class Edge implements Comparable<Edge> {
    private int x;
    private int y;
    private int len;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Edge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    @Override
    public int compareTo(Edge o) {//内置比较器实现按len升序
        return Integer.compare(this.len, o.len);
    }
}
