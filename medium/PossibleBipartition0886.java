package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/8 13:54
 */
public class PossibleBipartition0886 {
    // 使用邻接表存储图
    ArrayList<Integer>[] graph;
    //记录上色结果
    Map<Integer,Integer> color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // 0位其实不用,使用的使1~N位
        graph=new ArrayList[N+1];
        //ArrayList实例化
        for (int i = 0; i !=N+1; i++) {
            graph[i]=new ArrayList<Integer>();
        }
        //图初始化
        for(int[] cp:dislikes) {
            graph[cp[0]].add(cp[1]);
            graph[cp[1]].add(cp[0]);
        }
        color=new HashMap();
        // 对该组N人遍历
        for(int node=1;node!=N+1;node++) {
            // 还未上色
            if(!color.containsKey(node)) {
                //从node开始深度遍历
                boolean OK=dfs(node,0);
                if(!OK) {
                    return false;
                }
            }else {
                //已经上色
                continue;
            }
        }
        return true;
    }
    private boolean dfs(int node, int c) {
        //从possibleBipartition调用时node是未上色的
        // 若已经上色则看是否上色正确
        if(color.containsKey(node)) {
            boolean OK=color.get(node)==c;
            return OK;
        }
        // 上色
        color.put(node,c);
        // 深度遍历
        for(int noFriend:graph[node]) {
            boolean OK=dfs(noFriend,c^1);
            if(!OK) {
                return false;
            }
        }
        return true;
    }

}
