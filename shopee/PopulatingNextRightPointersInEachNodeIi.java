package shopee;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 17:15
 */
public class PopulatingNextRightPointersInEachNodeIi {
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
    };

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 0; i < n; i++) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 0) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }

    Node last = null, nextStart = null;

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
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
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}
