package lcof;

import java.util.HashMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 16:01
 */
public class Lcof35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 100.00%
     * 57.20%
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node cur=head;
        //复制结点值
        while(cur!=null){
            //存储put:<key,value1>
            //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        //复制结点指向
        cur = head;
        while(cur!=null){
            //得到get:<key>.value2,3
            //新结点next指向同旧结点的next指向
            map.get(cur).next = map.get(cur.next);
            //新结点random指向同旧结点的random指向
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回复制的链表
        return map.get(head);
    }
}
