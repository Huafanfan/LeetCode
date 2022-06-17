package neetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/17 10:25
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node start = head;
        while (start != null){
            Node node = new Node(start.val);
            map.put(start, node);
            start = start.next;
        }
        start = head;
        while (start != null){
            map.get(start).next = map.get(start.next);
            map.get(start).random = map.get(start.random);
            start = start.next;
        }
        return map.get(head);
    }
}
