package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/13 15:18
 */
public class CourseScheduleii0210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            edges.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        int index = 0;
        for (int[] p : prerequisites){
            edges.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int root = queue.poll();
            res[index++] = root;
            for (Integer node : edges.get(root)){
                if (--inDegree[node] == 0){
                    queue.offer(node);
                }
            }
        }

        if (index == numCourses){
            return res;
        }
        else {
            return new int[0];
        }
    }
}
