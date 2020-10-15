package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/15 09:28
 */
public class PopulatingNextRightPointersinEachNode0116 {
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

    public Node connect1(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        if (root == null){
            return null;
        }
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            Node last = nodeQueue.poll();
            for (int i=1; i<size; i++){
                Node cur = nodeQueue.poll();
                last.next = cur;
                if (last.left!=null){
                    nodeQueue.offer(last.left);
                }
                if (last.right!=null){
                    nodeQueue.offer(last.right);
                }
                last = cur;
            }
            last.next = null;
            if (last.left!=null){
                nodeQueue.offer(last.left);
            }
            if (last.right!=null){
                nodeQueue.offer(last.right);
            }
        }
        return root;
    }

    public Node connect2(Node root){
        if (root == null){
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null){
            Node head= leftmost;
            while (head != null){
                head.left.next = head.right;
                if (head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public Node connect3(Node root){
        if (root==null||root.right==null){
            return root;
        }
        root.left.next = root.right;
        if (root.next != null){
            root.right.next = root.next.left;
        }
        connect3(root.left);
        connect3(root.right);
        return root;
    }


}
