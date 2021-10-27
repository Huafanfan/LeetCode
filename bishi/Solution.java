package bishi;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/6 09:46
 */
public class Solution {
    static class Node{
        int x,y,z;
        int id;
        public Node(int _x, int _y, int _z, int _id){
            x = _x;
            y = _y;
            z = _z;
            id = _id;
        }
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", id=" + id +
                    '}';
        }
    }
    public static void main(String[] args) {
        Node[] list = new Node[5];
        list[0] = new Node(1,1,1,3);
        list[1] = new Node(1,1,1,2);
        list[2] = new Node(2,1,3,1);
        list[3] = new Node(1,1,1,4);
        list[4] = new Node(2,1,3,5);
        System.out.println(Arrays.toString(list));
        for (int index = 0; index<list.length; index++){
            for (int other = 0; other < index; other++){
                if (list[index].x == list[other].x && list[index].y == list[other].y && list[index].z == list[other].z ){
                    list[other].id = list[index].id;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }

    Set<Set<Integer>> mark = new HashSet<>();
    public int func(int n,Map<Integer, List<Integer>> edge){
        for (int i=1; i<=n; i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            dfs(i, edge, set);
        }
        return mark.size();
    }

    public void dfs(int cur, Map<Integer, List<Integer>> edge, Set<Integer> set){
        if (set.size() == 5){
            mark.add(new HashSet<>(set));
            return;
        }
        for (int i=0; i<edge.get(cur).size(); i++){
            int next = edge.get(cur).get(i);
            if (!set.contains(next)){
                set.add(next);
                dfs(next, edge, set);
                set.remove(next);
            }
        }
    }
}
