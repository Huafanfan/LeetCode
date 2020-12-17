package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 16:29
 */
public class Lcof36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node cur = root;
        while (cur!=null){
            Node last = cur.left;
            while (last!=null && last.right!=null){
                last = last.right;
            }
            last.right = cur;
            cur.left = last;
            Node next = cur.right;
            while (next!=null && next.left!=null){
                next = next.left;
            }
            next.left = cur;
            cur.right = next;
        }
        return null;
    }
}
