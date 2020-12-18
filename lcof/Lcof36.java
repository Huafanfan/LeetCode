package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 16:29
 */
public class Lcof36 {
    static class Node {
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

    /**
     * 100.00%
     * 85.14%
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        Node mid = dfs(root);
        Node min = mid;
        Node max = mid;
        while (min!=null && min.left!=null){
            min = min.left;
        }
        while (max!=null && max.right!=null){
            max = max.right;
        }
        if (min != null){
            min.left = max;
            max.right = min;
        }
        return min;
    }

    public Node dfs(Node root) {
        if (root == null){
            return null;
        }
        if (root.right != null){
            dfs(root.right);
        }
        if (root.left != null){
            dfs(root.left);
        }
        Node last = root.left;
        while (last!=null && last.right!=null){
            last = last.right;
        }
        if (last!=null){
            last.right = root;
        }
        root.left = last;

        Node next = root.right;
        while (next!=null && next.left!=null){
            next = next.left;
        }
        if (next!=null){
            next.left = root;
        }
        root.right = next;

        return root;
    }

    Node pre, head;

    /**
     * 100.00%
     * 85.14%
     * @param root
     * @return
     */
    public Node treeToDoublyList2(Node root) {
        if(root == null) {
            return null;
        }
        dfs2(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs2(Node cur) {
        if(cur == null) {
            return;
        }
        dfs2(cur.left);
        if(pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs2(cur.right);
    }

    public static void main(String[] args) {
        Lcof36 lcof36 = new Lcof36();
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);

        node3.left = node2;
        node4.left = node3;
        node4.right = node6;
        node6.left = node5;
        node6.right = node7;
        node8.left = node4;
        node8.right = node10;
        node10.left = node9;
        node10.right = node11;

        Node res = lcof36.treeToDoublyList(node8);

        System.out.println(res.val);

    }
}
