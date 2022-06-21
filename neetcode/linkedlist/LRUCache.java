package neetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/21 12:12
 */
public class LRUCache {
    Map<Integer, ListNode> map = new HashMap<>();
    int capacity = 0;
    int size = 0;
    ListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.last = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null){
            return -1;
        } else {
            moveHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null){
            node = new ListNode();
            node.val = value;
            node.key = key;
            if (size < capacity){
                size++;
            } else {
                map.remove(tail.last.key);
                removeNode(tail.last);
            }
            map.put(key, node);
            addHead(node);
        } else {
            node.val = value;
            moveHead(node);
        }
    }
    public void moveHead(ListNode node){
        removeNode(node);
        addHead(node);
    }

    public void removeNode(ListNode node){
        node.last.next = node.next;
        node.next.last = node.last;
    }

    public void addHead(ListNode node){
        node.next = head.next;
        head.next.last = node;
        head.next = node;
        node.last = head;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
