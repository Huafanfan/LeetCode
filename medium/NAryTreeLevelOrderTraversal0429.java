package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/8 08:31
 */
public class NAryTreeLevelOrderTraversal0429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++){
                Node cur = queue.pollFirst();
                level.add(cur.val);
                for (int j=0; j<cur.children.size(); j++){
                    queue.addLast(cur.children.get(j));
                }
            }
            res.add(level);
        }
        return res;
    }

}
