package byteDance;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIi {
    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
    int[] result;
    // 判断有向图中是否有环
    boolean valid = true;
    // 栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
        }
        for (int i=0; i<numCourses && valid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }
        if (!valid){
            return new int[0];
        }
        return result;
    }

    public void dfs(int i){
        visited[i] = 1;
        for (int v : edges.get(i)){
            if (visited[v] == 0){
                dfs(v);
                if (!valid){
                    return;
                }
            }
            else if (visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        result[index--] = i;
    }
}
