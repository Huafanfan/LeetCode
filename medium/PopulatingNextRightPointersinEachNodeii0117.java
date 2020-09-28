package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/28 10:09
 */
public class PopulatingNextRightPointersinEachNodeii0117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            int n = nodeQueue.size();
            Node last = null;
            for (int i = 0; i < n; ++i) {
                Node f = nodeQueue.poll();
                if (f.left != null) {
                    nodeQueue.offer(f.left);
                }
                if (f.right != null) {
                    nodeQueue.offer(f.right);
                }
                if (i != 0) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }

    /**
     * 从根节点开始。因为第 0 层只有一个节点，不需要处理。
     * 可以在上一层为下一层建立 next 指针。该方法最重要的一点是：位于第 x 层时为第 x+1 层建立 next 指针。
     * 一旦完成这些连接操作，移至第 x+1 层为第 x+2 层建立 next 指针。
     */
    Node last =  null;
    Node nextStart = null;
    public Node connect2(Node root) {
        if (root == null){
            return null;
        }
        Node start = root;
        while (start!=null){
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next){
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null){
            last.next = p;
        }
        //下一层的第一个节点就是nextStart
        if (nextStart == null){
            nextStart = p;
        }
        last = p;
    }
}
